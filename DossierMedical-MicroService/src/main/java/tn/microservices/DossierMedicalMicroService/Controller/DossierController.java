package tn.microservices.DossierMedicalMicroService.Controller;


import tn.microservices.DossierMedicalMicroService.Service.IServiceDossier;
import tn.microservices.DossierMedicalMicroService.dto.DossierMedicalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/dossiers")
@CrossOrigin(origins = "http://localhost:4200")
public class DossierController {

    @Autowired
    private IServiceDossier serviceDossier;

    @PostMapping("/Add")
    public ResponseEntity<DossierMedicalDTO> createDossier(
            @RequestPart("dossier") DossierMedicalDTO dossierMedicalDTO,
            @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {

        // Si une image a été téléchargée, ajoutez-la au dossier
        if (image != null && !image.isEmpty()) {
            dossierMedicalDTO.setByteImg(image.getBytes()); // Assurez-vous que votre DTO a un champ pour l'image
        }

        // Créer le nouveau dossier
        DossierMedicalDTO newDossier = serviceDossier.createDossier(dossierMedicalDTO);

        // Retourner le nouveau dossier avec un statut 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(newDossier);
    }



    @GetMapping("/{id}")
    public ResponseEntity<DossierMedicalDTO> getDossierById(@PathVariable Long id) {
        return serviceDossier.getDossierById(id)
                .map(dossier -> ResponseEntity.ok(dossier.getDto()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public ResponseEntity<List<DossierMedicalDTO>> getAllDossiers() {
        List<DossierMedicalDTO> dossiers = serviceDossier.getAllDossiers();
        return ResponseEntity.ok(dossiers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DossierMedicalDTO> updateDossier(@PathVariable Long id, @RequestBody DossierMedicalDTO dossierMedicalDTO) {
        DossierMedicalDTO updatedDossier = serviceDossier.updateDossier(id, dossierMedicalDTO);
        return ResponseEntity.ok(updatedDossier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDossier(@PathVariable Long id) {
        serviceDossier.deleteDossier(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<DossierMedicalDTO>> searchDossier(
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String dateNaissance // Passée en format "yyyy-MM-dd"
    ) {
        LocalDate birthDate = LocalDate.parse(dateNaissance);
        List<DossierMedicalDTO> result = serviceDossier.searchByNomPrenomDate(nom, prenom, birthDate);
        return ResponseEntity.ok(result);
    }
}
