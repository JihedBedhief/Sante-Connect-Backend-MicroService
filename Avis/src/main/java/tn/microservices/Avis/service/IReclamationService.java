package tn.microservices.Avis.service;

import tn.microservices.Avis.Dto.ReclamationDto;

import java.util.List;

public interface IReclamationService {
    ReclamationDto saveReclamation(ReclamationDto reclamationDto);
    ReclamationDto getReclamationById(Long id);
    List<ReclamationDto> getAllReclamations();
    ReclamationDto updateReclamation(Long id, ReclamationDto reclamationDto);
    void deleteReclamation(Long id);
}
