package sn.ucad.informatique.soa.msnote;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class RestTemplateResponseErrorHandle implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (
                clientHttpResponse.getStatusCode().is4xxClientError()
                || clientHttpResponse.getStatusCode().is5xxServerError()
        );
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if (clientHttpResponse.getStatusCode().is4xxClientError() ){
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(clientHttpResponse.getBody()))){
                String httpResponse = reader.lines().collect(Collectors.joining(""));
                String errorMessage = httpResponse;

                throw new RestTemplateException(clientHttpResponse.getStatusCode(),errorMessage);
            }
        }

    }
}
