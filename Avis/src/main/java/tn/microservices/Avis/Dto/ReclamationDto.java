package tn.microservices.Avis.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReclamationDto {
    private Long id ;
    private String status ;
    private String description ;
    private String type ;
    private String date ;



}
