package sn.ucad.informatique.soa.msstage;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StageRequest {
    @NotBlank
    private String numeroEtudiant;
    @NotBlank
    private String nomEntreprise;
}
