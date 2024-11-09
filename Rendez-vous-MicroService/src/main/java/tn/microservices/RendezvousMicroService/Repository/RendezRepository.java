package tn.microservices.RendezvousMicroService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.microservices.RendezvousMicroService.Entity.RendezVous;

@Repository
public interface RendezRepository extends JpaRepository<RendezVous,Long> {
}
