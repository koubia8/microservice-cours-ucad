package sn.ucad.informatique.soa.msetudiant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EtudiantNotFoundException extends RuntimeException {
    public EtudiantNotFoundException(String message) {
        super(message);
    }
}
