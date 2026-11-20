package tn.esprit.tp_foyer.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tp_foyer.domain.Maintenance;
import tn.esprit.tp_foyer.web.dto.MaintenanceDTO;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {

    @Mapping(target = "idVehicule",
            source = "vehicule.idVehicule")

    @Mapping(target = "immatriculationVehicule",
            source = "vehicule.immatriculation")

    MaintenanceDTO toDto(Maintenance maintenance);
}
