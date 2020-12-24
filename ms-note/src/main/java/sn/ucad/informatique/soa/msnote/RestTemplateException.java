package sn.ucad.informatique.soa.msnote;

import org.springframework.http.HttpStatus;

public class RestTemplateException extends RuntimeException {

    private HttpStatus statusCode;
    private String error;

    public RestTemplateException(HttpStatus statusCode, String error) {

        this.statusCode = statusCode;
        this.error = error;
    }
}
