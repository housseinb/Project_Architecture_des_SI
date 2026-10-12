package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.domain.Equipement;

public interface IEquipementRepository extends JpaRepository<Equipement, Long> {
}
