package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.domain.Contrat;

public interface IContratRepository extends JpaRepository<Contrat, Long> {
}
