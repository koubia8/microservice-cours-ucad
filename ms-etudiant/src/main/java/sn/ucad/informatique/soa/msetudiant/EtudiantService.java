package sn.ucad.informatique.soa.msetudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant createNewEtudiant(EtudiantRequest etudiantRequest){
        Optional<Etudiant> etudiantFromDB= etudiantRepository.findEtudiantByNumeroEtudiant(etudiantRequest.getNumeroEtudiant());
        if (etudiantFromDB.isPresent()){
            throw new EtudiantConflitException(String.format("Le numéro %s de l'etudiant existe dèja ",etudiantRequest.getNumeroEtudiant()));
        }
        Etudiant newEtudiant= new Etudiant();
        newEtudiant.setNom(etudiantRequest.getNom());
        newEtudiant.setPrenom(etudiantRequest.getPrenom());
        newEtudiant.setNumeroEtudiant(etudiantRequest.getNumeroEtudiant());
        return etudiantRepository.save(newEtudiant);
    }
    public Etudiant getEtudiantByNumeroClient(String numero){
        Optional<Etudiant> etudiantFromDB = etudiantRepository.findEtudiantByNumeroEtudiant(numero);
        if (etudiantFromDB.isEmpty()){
            throw new EtudiantNotFoundException(String.format("Le numéro %s de l'etudiant existe pas",numero));
        }
        return  etudiantFromDB.get();
    }

    public List<Etudiant> findAllEtudiant(){
        return etudiantRepository.findAll();
    }
}
