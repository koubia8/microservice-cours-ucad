package sn.ucad.informatique.soa.msstage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "stages")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Stage {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(name = "numero_etudiant")
    @NotBlank
    @JsonIgnore
    private String numeroEtudiant;
    @Column(name = "numero_entreprise")
    @NotBlank
    private String nomEntreprise;
}
