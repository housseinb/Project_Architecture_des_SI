package tn.esprit.tp_foyer.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@ToString(includeFieldNames = true)
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private Long idReservation;

    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutReservation statut;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vehicule", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Vehicule vehicule;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Client client;

    @OneToOne(mappedBy = "reservation")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Contrat contrat;
}
