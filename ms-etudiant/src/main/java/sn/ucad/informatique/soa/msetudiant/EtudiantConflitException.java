package sn.ucad.informatique.soa.msetudiant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EtudiantConflitException extends RuntimeException {
    public EtudiantConflitException(String message) {
        super(message);
    }
}
