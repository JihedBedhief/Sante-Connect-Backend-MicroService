package tn.microservices.RendezvousMicroService.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.microservices.RendezvousMicroService.Dto.RendezDto;
import tn.microservices.RendezvousMicroService.Entity.RendezVous;
import tn.microservices.RendezvousMicroService.Repository.RendezRepository;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")  // Allows CORS for this controller
public class ServiceRendez {
    private final RendezRepository rendezRepository;

    public RendezDto addrendezvous(RendezDto rendezDto) throws IOException {
        RendezVous rendezVous = new RendezVous();
        rendezVous.setDate(rendezDto.getDate());
        rendezVous.setId(rendezDto.getId());
        rendezVous.setTemps(rendezDto.getTemps());
        rendezVous.setStaus(false);
        rendezVous.setPatientId(rendezDto.getPatientId());
        rendezVous.setDocteurId(rendezDto.getDocteurId());
        rendezVous.setDescription(rendezDto.getDescription());
        return rendezRepository.save(rendezVous).getDto();
    }
    public RendezDto getItemById(Long id){
        Optional<RendezVous> optionalItems = rendezRepository.findById(id);
        if (optionalItems.isPresent()){
            return optionalItems.get().getDto();
        }else {
            return null;
        }

    }


    public RendezDto updateDto(Long id , RendezDto rendezDto) throws IOException {
        Optional<RendezVous> optionalItems = rendezRepository.findById(id);
        if (optionalItems.isPresent() ){
            RendezVous rendezVous = optionalItems.get();
            rendezVous.setDate(rendezDto.getDate());
            rendezVous.setId(rendezDto.getId());
            rendezVous.setTemps(rendezDto.getTemps());
            rendezVous.setStaus(rendezDto.getStaus());
            rendezVous.setPatientId(rendezDto.getPatientId());
            rendezVous.setDocteurId(rendezDto.getDocteurId());
            rendezVous.setDescription(rendezDto.getDescription());

            return rendezRepository.save(rendezVous).getDto();
        }else {
            return null;
        }
    }

    public List<RendezDto> getAll(){
        List<RendezVous> rendezVous = rendezRepository.findAll();
        return rendezVous.stream().map(RendezVous::getDto).collect(Collectors.toList());
    }


    public boolean delete(Long id){
        Optional<RendezVous> optionalProduct= rendezRepository.findById(id);
        if(optionalProduct.isPresent()){
            rendezRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }


    public RendezDto accept(Long id ) throws IOException {
        Optional<RendezVous> optionalItems = rendezRepository.findById(id);
        if (optionalItems.isPresent() ){
            RendezVous rendezVous = optionalItems.get();
            rendezVous.setStaus(true);
            return rendezRepository.save(rendezVous).getDto();
        }else {
            return null;
        }
    }


}
