package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.domain.Agence;

public interface IAgenceRepository extends JpaRepository<Agence, Long> {
}
