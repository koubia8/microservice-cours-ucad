package sn.ucad.informatique.soa.msetudiant;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "etudiants", uniqueConstraints={@UniqueConstraint(columnNames = {
        "numero_etudiant"
})})
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "numero_etudiant",nullable = false)
    private String numeroEtudiant;
    @Column(name = "prenom",nullable = false)
    private String prenom;
    @Column(name = "nom",nullable = false)
    private String nom;

    public Etudiant() {
    }

    public Etudiant(String numeroEtudiant, String prenom, String nom) {
        this.numeroEtudiant = numeroEtudiant;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEdutiant) {
        this.numeroEtudiant = numeroEdutiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
