package sn.ucad.informatique.soa.msnote;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EtudiantNotFoundException extends RuntimeException {
    public EtudiantNotFoundException(String format) {
        super(format);
    }

}
