package tn.microservices.DossierMedicalMicroService.dto;

import tn.microservices.DossierMedicalMicroService.Enum.TypeSanguin;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DossierMedicalDTO {

    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String genre; // ou utiliser une énumération si souhaité
    private String adresse;
    private String numeroTelephone;
    private String email;
    private byte[] byteImg ;
    private TypeSanguin typeSanguin;
    private String antecedentsMedicaux;
    private String allergies;
    private  String medicaments;
    private  String notesConsultations;
    private String personneContactUrgence;
    private String relationContactUrgence;
    private String numeroContactUrgence;
}
