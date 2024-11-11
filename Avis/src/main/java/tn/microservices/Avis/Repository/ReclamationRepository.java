package tn.microservices.Avis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.microservices.Avis.Entities.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}

