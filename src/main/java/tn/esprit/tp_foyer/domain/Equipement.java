package tn.esprit.tp_foyer.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipement")
@Getter
@Setter
@ToString(includeFieldNames = true)
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private Long idEquipement;

    @Column(nullable = false, unique = true, length = 100)
    private String libelle;

    @Builder.Default
    @ManyToMany(mappedBy = "equipements")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vehicule> vehicules = new ArrayList<>();
}
