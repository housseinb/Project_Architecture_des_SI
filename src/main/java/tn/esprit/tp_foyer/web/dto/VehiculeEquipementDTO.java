package tn.esprit.tp_foyer.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeEquipementDTO {

    @NotNull(message = "L'identifiant du véhicule est obligatoire")
    @Positive(message = "L'identifiant du véhicule doit être positif")
    private Long idVehicule;

    @NotNull(message = "L'identifiant de l'équipement est obligatoire")
    @Positive(message = "L'identifiant de l'équipement doit être positif")
    private Long idEquipement;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String immatriculation;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String libelleEquipement;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Libellés de tous les équipements du véhicule")
    private List<String> equipementsVehicule;
}
