package tn.esprit.tp_foyer.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paiement")
@Getter
@Setter
@ToString(includeFieldNames = true)
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private Long idPaiement;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montant;

    @Column(nullable = false)
    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ModePaiement modePaiement;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Contrat contrat;
}
