package sn.ucad.informatique.soa.msnote;

import lombok.Data;

import java.io.Serializable;

@Data
public class Etudiant implements Serializable {
    private String nom;
    private String prenom;
    private String numeroEtudiant;
}
