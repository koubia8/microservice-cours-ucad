package sn.ucad.informatique.soa.msnote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    private final String apiEtudiant = "http://localhost:9001/api/etudiant";

    public NoteService(RestTemplateBuilder  restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandle())
                .build();

    }

    // ajouter une note
    public Note createNewNote(NoteRequest noteRequest){
        // faire un appel sur l'api etudiant pour verifier le numero etudiant
        restTempletInstance(noteRequest.getNumeroEtudiant());
        Note newNote= new Note();
        newNote.setNomMatiere(noteRequest.getNomMatiere());
        newNote.setNumeroEtudiant(noteRequest.getNumeroEtudiant());
        newNote.setNote(noteRequest.getNote());
        return noteRepository.save(newNote);
    }
    public NoteEtudiantReponse findNoteByEtudiant(String numero){
        restTempletInstance(numero);
        List<Note> notesFromDb= noteRepository.findNoteByNumeroEtudiant(numero);
        List<Note> notes=new ArrayList<>();
        notesFromDb.forEach(noteDB -> {
            Note note= new Note();
            note.setNomMatiere(noteDB.getNomMatiere());
            note.setNote(noteDB.getNote());
            notes.add(note);
        });
        Etudiant etudiant = getEtudiant(numero);
        NoteEtudiantReponse noteEtudiantReponse = new NoteEtudiantReponse();
        noteEtudiantReponse.setEtudiant(etudiant);
        noteEtudiantReponse.setMesNotes(notes);
        return noteEtudiantReponse;
    }
    private void  restTempletInstance(String numeroEtudiant){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response= restTemplate.getForEntity(apiEtudiant+"/"+numeroEtudiant, Object.class);
    }
    private Etudiant  getEtudiant(String numeroEtudiant){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Etudiant> response= restTemplate.getForEntity(apiEtudiant+"/"+numeroEtudiant, Etudiant.class);

        return  response.getBody();
    }
}
