package tn.microservices.DossierMedicalMicroService.Service;


import tn.microservices.DossierMedicalMicroService.Entity.Dossier;
import tn.microservices.DossierMedicalMicroService.Repository.DossierRepository;
import tn.microservices.DossierMedicalMicroService.dto.DossierMedicalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceDossierImp implements IServiceDossier {

    @Autowired
    private DossierRepository dossierRepository;

    @Override
    public DossierMedicalDTO createDossier(DossierMedicalDTO dossierMedicalDTO) {
        // Convertir le DTO en entité
        Dossier dossier = new Dossier();
        updateDossierFromDTO(dossierMedicalDTO, dossier);

        // Sauvegarder l'entité
        Dossier savedDossier = dossierRepository.save(dossier);

        // Retourner le DTO de l'entité sauvegardée
        return savedDossier.getDto();
    }

    @Override
    public DossierMedicalDTO updateDossier(Long id, DossierMedicalDTO dossierMedicalDTO) {
        Optional<Dossier> existingDossier = dossierRepository.findById(id);
        if (existingDossier.isPresent()) {
            Dossier dossier = existingDossier.get();
            updateDossierFromDTO(dossierMedicalDTO, dossier);
            Dossier updatedDossier = dossierRepository.save(dossier);
            return updatedDossier.getDto();
        } else {
            throw new RuntimeException("Dossier médical non trouvé avec l'id : " + id);
        }
    }

    @Override
    public Optional<Dossier> getDossierById(Long id) {
        return dossierRepository.findById(id);
    }

    @Override
    public List<DossierMedicalDTO> getAllDossiers() {
        List<Dossier> dossiers = dossierRepository.findAll();
        return dossiers.stream().map(Dossier::getDto).collect(Collectors.toList());
    }
    
    @Override
    public List<DossierMedicalDTO> searchByNomPrenomDate(String nom, String prenom, LocalDate dateNaissance) {
        List<Dossier> dossiers = dossierRepository.findByNomAndPrenomAndDateNaissance(nom, prenom, dateNaissance);
        return dossiers.stream().map(Dossier::getDto).collect(Collectors.toList());
    }

    @Override
    public void deleteDossier(Long id) {
        Optional<Dossier> dossier = dossierRepository.findById(id);
        if (dossier.isPresent()) {
            dossierRepository.deleteById(id);
        } else {
            throw new RuntimeException("Dossier médical non trouvé avec l'id : " + id);
        }
    }

    // Méthode pour mapper un DTO vers une entité Dossier
    private void updateDossierFromDTO(DossierMedicalDTO dto, Dossier dossier) {
        dossier.setNom(dto.getNom());
        dossier.setPrenom(dto.getPrenom());
        dossier.setDateNaissance(dto.getDateNaissance());
        dossier.setGenre(dto.getGenre());
        dossier.setAdresse(dto.getAdresse());
        dossier.setNumeroTelephone(dto.getNumeroTelephone());
        dossier.setEmail(dto.getEmail());
        dossier.setImg(dto.getByteImg());
        dossier.setTypeSanguin(dto.getTypeSanguin());
        dossier.setAntecedentsMedicaux(dto.getAntecedentsMedicaux());
        dossier.setAllergies(dto.getAllergies());
        dossier.setMedicaments(dto.getMedicaments());
        dossier.setNotesConsultations(dto.getNotesConsultations());
        dossier.setPersonneContactUrgence(dto.getPersonneContactUrgence());
        dossier.setRelationContactUrgence(dto.getRelationContactUrgence());
        dossier.setNumeroContactUrgence(dto.getNumeroContactUrgence());
    }
}
