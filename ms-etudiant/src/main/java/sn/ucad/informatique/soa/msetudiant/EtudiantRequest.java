package sn.ucad.informatique.soa.msetudiant;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

public class EtudiantRequest {
    @NotBlank
    private String numeroEtudiant;
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
