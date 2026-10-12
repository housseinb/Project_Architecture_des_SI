package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.domain.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}
