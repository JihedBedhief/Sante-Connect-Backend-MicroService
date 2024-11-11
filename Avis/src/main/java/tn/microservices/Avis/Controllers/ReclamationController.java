package tn.microservices.Avis.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.microservices.Avis.Dto.ReclamationDto;
import tn.microservices.Avis.service.ReclamationService;

import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;

    @PostMapping("/Add")
    public ResponseEntity<ReclamationDto> createReclamation(@RequestBody ReclamationDto reclamationDto) {
        ReclamationDto savedReclamation = reclamationService.saveReclamation(reclamationDto);
        return ResponseEntity.ok(savedReclamation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReclamationDto> getReclamationById(@PathVariable Long id) {
        ReclamationDto reclamation = reclamationService.getReclamationById(id);
        return ResponseEntity.ok(reclamation);
    }
    @GetMapping("")
    public ResponseEntity<List<ReclamationDto>> getAllReclamations() {
        List<ReclamationDto> reclamations = reclamationService.getAllReclamations();
        return ResponseEntity.ok(reclamations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReclamationDto> updateReclamation(@PathVariable Long id, @RequestBody ReclamationDto reclamationDto) {
        ReclamationDto updatedReclamation = reclamationService.updateReclamation(id, reclamationDto);
        return ResponseEntity.ok(updatedReclamation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
        return ResponseEntity.noContent().build();
    }
}

