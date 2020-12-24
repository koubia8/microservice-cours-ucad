package sn.ucad.informatique.soa.msnote;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class NoteRequest {
    @NotBlank
    private String numeroEtudiant;
    @NotBlank
    private String nomMatiere;
    @NotNull
    private int note;
}
