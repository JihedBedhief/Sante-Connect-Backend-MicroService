package tn.microservices.DossierMedicalMicroService.Repository;

import tn.microservices.DossierMedicalMicroService.Entity.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DossierRepository  extends JpaRepository<Dossier,Long> {
    List<Dossier> findByNomAndPrenomAndDateNaissance(String nom, String prenom, LocalDate dateNaissance);

}
