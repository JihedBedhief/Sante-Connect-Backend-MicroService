package tn.microservices.Avis.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.microservices.Avis.Dto.ReclamationDto;
import tn.microservices.Avis.Entities.Reclamation;
import tn.microservices.Avis.Repository.ReclamationRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReclamationService implements IReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public ReclamationDto saveReclamation(ReclamationDto reclamationDto) {
        Reclamation reclamation = new Reclamation();
        reclamation.setDescription(reclamationDto.getDescription());
        reclamation.setStatus(reclamationDto.getStatus());
        reclamation.setType(reclamationDto.getType());
        reclamation.setTemps(reclamationDto.getDate());
        reclamation = reclamationRepository.save(reclamation);
        return mapToDto(reclamation);
    }

    @Override
    public ReclamationDto getReclamationById(Long id) {
        Reclamation reclamation = reclamationRepository.findById(id).orElseThrow();
        return mapToDto(reclamation);
    }

    @Override
    public List<ReclamationDto> getAllReclamations() {
        return reclamationRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReclamationDto updateReclamation(Long id, ReclamationDto reclamationDto) {
        Reclamation reclamation = reclamationRepository.findById(id).orElseThrow();
        reclamation.setDescription(reclamationDto.getDescription());
        reclamation.setStatus(reclamationDto.getStatus());
        reclamation.setType(reclamationDto.getType());
        reclamation.setTemps(reclamationDto.getDate());
        reclamation = reclamationRepository.save(reclamation);
        return mapToDto(reclamation);
    }

    @Override
    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }

    private ReclamationDto mapToDto(Reclamation reclamation) {
        ReclamationDto dto = new ReclamationDto();
        dto.setId(reclamation.getId());
        dto.setDescription(reclamation.getDescription());
        dto.setStatus(reclamation.getStatus());
        dto.setType(reclamation.getType().toString());
        dto.setDate(reclamation.getTemps());
        return dto;
    }
}
