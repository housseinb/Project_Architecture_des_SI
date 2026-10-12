package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.domain.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement findById(Long id);
    List<Paiement> findAll();
}
