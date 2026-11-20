package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.domain.Maintenance;
import tn.esprit.tp_foyer.web.dto.MaintenanceDTO;

import java.util.List;

public interface IMaintenanceService {
    Maintenance create(Maintenance maintenance);
    Maintenance findById(Long id);
    List<Maintenance> findAll();
    Maintenance update(Long id, Maintenance maintenance);
    MaintenanceDTO affecterMaintenanceAVehicule(MaintenanceDTO dto);
    void deleteById(Long id);
}
