package sn.ucad.informatique.soa.msnote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/note")
public class Route {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid  @RequestBody NoteRequest noteRequest){
        return ResponseEntity.ok(noteService.createNewNote(noteRequest));
    }

    @GetMapping("/{numero}")
    public ResponseEntity<NoteEtudiantReponse> findNoteByNumeroEtudiant(@PathVariable("numero") String numero){
        return ResponseEntity.ok(noteService.findNoteByEtudiant(numero));
    }
}
