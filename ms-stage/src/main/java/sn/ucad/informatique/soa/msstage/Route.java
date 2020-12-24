package sn.ucad.informatique.soa.msstage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/stage")
public class Route {
    @Autowired
    private StageService stageService;

    @PostMapping
    public ResponseEntity<Stage> createNewStage(@Valid @RequestBody StageRequest stageRequest){
        return ResponseEntity.ok(stageService.createStage(stageRequest));
    }

    @GetMapping("/{numero}")
    public ResponseEntity<StageReponse> findStageForEtudiant(@PathVariable("numero") String numero){
        return ResponseEntity.ok(stageService.findStageForEtudiant(numero));
    }
}
