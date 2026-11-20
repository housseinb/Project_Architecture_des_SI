package tn.esprit.tp_foyer.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tp_foyer.domain.Equipement;
import tn.esprit.tp_foyer.domain.Vehicule;
import tn.esprit.tp_foyer.web.dto.VehiculeEquipementDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiculeEquipementMapper {

    @Mapping(target = "idVehicule",
            source = "vehicule.idVehicule")

    @Mapping(target = "immatriculation",
            source = "vehicule.immatriculation")

    @Mapping(target = "idEquipement",
            source = "equipement.idEquipement")

    @Mapping(target = "libelleEquipement",
            source = "equipement.libelle")

    @Mapping(target = "equipementsVehicule",
            source = "vehicule.equipements")

    VehiculeEquipementDTO toDto(Vehicule vehicule, Equipement equipement);

    default String libelle(Equipement equipement) {
        return equipement.getLibelle();
    }
}
