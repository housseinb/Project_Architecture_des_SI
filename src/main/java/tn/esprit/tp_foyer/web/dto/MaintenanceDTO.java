package tn.esprit.tp_foyer.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long idMaintenance;

    @NotNull(message = "La date de début est obligatoire")
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @NotBlank(message = "La description est obligatoire")
    @Size(min = 5, max = 500, message = "La description doit contenir entre 5 et 500 caractères")
    private String description;

    @NotNull(message = "L'identifiant du véhicule est obligatoire")
    @Positive(message = "L'identifiant du véhicule doit être positif")
    private Long idVehicule;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String immatriculationVehicule;

    @JsonIgnore
    @Schema(hidden = true)
    @AssertTrue(message = "La date de fin ne peut pas être antérieure à la date de début")
    public boolean isPeriodeValide() {
        return dateFin == null || dateDebut == null || !dateFin.isBefore(dateDebut);
    }
}
