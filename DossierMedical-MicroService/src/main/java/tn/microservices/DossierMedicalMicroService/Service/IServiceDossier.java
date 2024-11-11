package tn.microservices.DossierMedicalMicroService.Service;


import tn.microservices.DossierMedicalMicroService.Entity.Dossier;
import tn.microservices.DossierMedicalMicroService.dto.DossierMedicalDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IServiceDossier {

    DossierMedicalDTO createDossier(DossierMedicalDTO dossierMedicalDTO); // Créer un nouveau dossier médical

    DossierMedicalDTO updateDossier(Long id, DossierMedicalDTO dossierMedicalDTO); // Mettre à jour un dossier médical

    Optional<Dossier> getDossierById(Long id); // Obtenir un dossier médical par ID

    List<DossierMedicalDTO> getAllDossiers(); // Obtenir tous les dossiers médicaux
    List<DossierMedicalDTO> searchByNomPrenomDate(String nom, String prenom, LocalDate dateNaissance);

    void deleteDossier(Long id); // Supprimer un dossier médical par ID
}

