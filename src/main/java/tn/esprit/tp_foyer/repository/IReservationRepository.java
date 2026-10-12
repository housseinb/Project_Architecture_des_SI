package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.domain.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
