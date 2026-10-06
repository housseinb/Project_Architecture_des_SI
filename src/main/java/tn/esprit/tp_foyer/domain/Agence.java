package tn.esprit.tp_foyer.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agence")
@Getter
@Setter
@ToString(includeFieldNames = true)
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private Long idAgence;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String ville;

    @Column(nullable = false, length = 255)
    private String adresse;

    @Column(nullable = false, length = 20)
    private String telephone;

    @Builder.Default
    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Employe> employes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vehicule> vehicules = new ArrayList<>();
}
