package sn.ucad.informatique.soa.msstage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StageService {
    @Autowired
    private StageRepository  stageRepository;
    private final String apiEtudiant = "http://localhost:9001/api/etudiant";

    public Stage createStage(StageRequest stageRequest){
        RestTemplate restTemplate = new RestTemplate();
        restTempletInstance(stageRequest.getNumeroEtudiant());
        Stage newStage= new Stage();
        newStage.setNumeroEtudiant(stageRequest.getNumeroEtudiant());
        newStage.setNomEntreprise(stageRequest.getNomEntreprise());
        return stageRepository.save(newStage);
    }

    private void  restTempletInstance(String numeroEtudiant){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response= restTemplate.getForEntity(apiEtudiant+"/"+numeroEtudiant, Object.class);
        if(response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            throw new EtudiantNotFoundException(String.format("Le numero %s n'existe pas dans la base donnée etudiant",numeroEtudiant));
        }
    }
    private Etudiant  getEtudiant(String numeroEtudiant){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Etudiant> response= restTemplate.getForEntity(apiEtudiant+"/"+numeroEtudiant, Etudiant.class);
        if(response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            throw new EtudiantNotFoundException(String.format("Le numero %s n'existe pas dans la base donnée etudiant",numeroEtudiant));
        }
        return  response.getBody();
    }

    public StageReponse findStageForEtudiant(String numero){
        List<Stage> stages= new ArrayList<>();
        List<Stage> stageFromDb= stageRepository.findStageByNumeroEtudiant(numero);
        // information etudiant : api etudiant
        Etudiant etudiant = getEtudiant(numero);
        // mes stages effectués
        stageFromDb.forEach(stage -> {
            Stage stageReponse = new Stage();
            stageReponse.setNomEntreprise(stage.getNomEntreprise());
            stages.add(stageReponse);
        });
        // object de reponse liste des stages

        StageReponse stageReponse = new StageReponse();
        stageReponse.setEtudiant(etudiant);
        stageReponse.setMesStage(stages);
        return stageReponse;
    }
}
