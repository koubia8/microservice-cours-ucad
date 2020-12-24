package sn.ucad.informatique.soa.msetudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
public class Route {
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    private ResponseEntity<Etudiant> createNewEtudiant(@Valid @RequestBody EtudiantRequest etudiantRequest){
        return ResponseEntity.ok(etudiantService.createNewEtudiant(etudiantRequest));
    }
    @GetMapping("/{numero}")
    private ResponseEntity<Etudiant> getEtudiant(@PathVariable("numero") String numero){
        return ResponseEntity.ok(etudiantService.getEtudiantByNumeroClient(numero));
    }

    @GetMapping
    private ResponseEntity<List<Etudiant>> findAll(){
        return ResponseEntity.ok(etudiantService.findAllEtudiant());
    }
}
