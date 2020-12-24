package sn.ucad.informatique.soa.msstage;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StageReponse {
    private Etudiant etudiant;
    private List<Stage> mesStage=new ArrayList<>();
}
