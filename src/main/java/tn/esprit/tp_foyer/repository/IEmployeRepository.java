package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.domain.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {
}
