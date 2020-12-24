package sn.ucad.informatique.soa.msetudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Optional<Etudiant> findEtudiantByNumeroEtudiant(String numero);

}
