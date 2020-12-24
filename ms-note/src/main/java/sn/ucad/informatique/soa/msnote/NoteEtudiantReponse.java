package sn.ucad.informatique.soa.msnote;

import lombok.Data;

import java.util.List;

@Data
public class NoteEtudiantReponse {
    private Etudiant etudiant;
    private List<Note> mesNotes;
}
