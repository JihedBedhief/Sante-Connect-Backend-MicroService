package tn.microservices.DossierMedicalMicroService.Entity;

import tn.microservices.DossierMedicalMicroService.Enum.TypeSanguin;
import tn.microservices.DossierMedicalMicroService.dto.DossierMedicalDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Setter
@Getter
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String genre;
    private String adresse;
    private String numeroTelephone;
    private String email;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img ;
    @Enumerated(EnumType.STRING)
    private TypeSanguin typeSanguin;

    private String antecedentsMedicaux;


    private String allergies;

    private String medicaments;

    private String notesConsultations;

    private String personneContactUrgence;
    private String relationContactUrgence;
    private String numeroContactUrgence;

    public DossierMedicalDTO getDto() {
        DossierMedicalDTO dto = new DossierMedicalDTO();
        dto.setId(this.id);
        dto.setNom(this.nom);
        dto.setPrenom(this.prenom);
        dto.setDateNaissance(this.dateNaissance);
        dto.setGenre(this.genre);
        dto.setAdresse(this.adresse);
        dto.setNumeroTelephone(this.numeroTelephone);
        dto.setEmail(this.email);
        dto.setByteImg(img);
        dto.setTypeSanguin(this.typeSanguin);
        dto.setAntecedentsMedicaux(antecedentsMedicaux);
        dto.setAllergies(allergies);
        dto.setMedicaments(this.medicaments);
        dto.setNotesConsultations(this.notesConsultations);
        dto.setPersonneContactUrgence(this.personneContactUrgence);
        dto.setRelationContactUrgence(this.relationContactUrgence);
        dto.setNumeroContactUrgence(this.numeroContactUrgence);
        return dto;
    }
}
