package tn.microservices.RendezvousMicroService.Entity;

import jakarta.persistence.*;
import lombok.Data;
import tn.microservices.RendezvousMicroService.Dto.RendezDto;

import java.util.Date;

@Entity
@Data
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private Date date ;
    private String temps ;
    private String docteurId ;
    private String patientId ;
    private Boolean staus ;

    public RendezDto getDto(){
        RendezDto rendezDto =new RendezDto();
        rendezDto.setId(id);
        rendezDto.setDate(date);
        rendezDto.setTemps(temps);
        rendezDto.setStaus(staus);
        rendezDto.setPatientId(patientId);
        rendezDto.setDocteurId(docteurId);
        return rendezDto;
    }
}
