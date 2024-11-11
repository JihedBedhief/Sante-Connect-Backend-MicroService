package tn.microservices.RendezvousMicroService.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class RendezDto {
    private Long id ;

    private String date ;
    private String temps ;
    private String docteurId ;
    private String patientId ;
    private Boolean staus ;
    private String description ;

}
