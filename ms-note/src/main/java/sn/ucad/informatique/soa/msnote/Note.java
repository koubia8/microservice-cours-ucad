package sn.ucad.informatique.soa.msnote;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notes")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(name = "numero_etudiant",nullable = false)
    @NotBlank
    @JsonIgnore
    private String numeroEtudiant;
    @Column(name = "nom_matiere",nullable = false)
    @NotBlank
    private String nomMatiere;
    @NotNull
    @Column(nullable = false,name = "note")
    private int note;

}
