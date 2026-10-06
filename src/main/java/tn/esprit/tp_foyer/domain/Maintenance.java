package tn.esprit.tp_foyer.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@ToString(includeFieldNames = true)
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private Long idMaintenance;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Column(nullable = false, length = 500)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vehicule", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Vehicule vehicule;
}
