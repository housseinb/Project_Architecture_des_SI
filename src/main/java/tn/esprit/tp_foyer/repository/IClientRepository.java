package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.domain.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
