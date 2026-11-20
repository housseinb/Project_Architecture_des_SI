package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.domain.Vehicule;
import tn.esprit.tp_foyer.web.dto.VehiculeEquipementDTO;

import java.util.List;

public interface IVehiculeService {
    Vehicule create(Vehicule vehicule);
    Vehicule findById(Long id);
    List<Vehicule> findAll();
    Vehicule update(Long id, Vehicule vehicule);

    Vehicule affecterVehiculeAAgence(Long idVehicule, Long idAgence);

    VehiculeEquipementDTO affecterEquipementAVehicule(VehiculeEquipementDTO dto);

    void deleteById(Long id);
}
