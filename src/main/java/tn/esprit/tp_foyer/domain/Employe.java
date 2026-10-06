package tn.esprit.tp_foyer.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employe")
@Getter
@Setter
@ToString(includeFieldNames = true)
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private Long idEmploye;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RoleEmploye role;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_agence", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Agence agence;
}
