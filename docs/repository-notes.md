# Atelier 3 - Spring Data JPA et repositories

Les neuf interfaces du package `repository` étendent `JpaRepository<Entité, Long>` : `IAgenceRepository`, `IEmployeRepository`, `IVehiculeRepository`, `IEquipementRepository`, `IClientRepository`, `IReservationRepository`, `IContratRepository`, `IPaiementRepository` et `IMaintenanceRepository`.

| Interface | Étend | Justification |
| --- | --- | --- |
| Toutes les interfaces `I…Repository` | `JpaRepository<Entité, Long>` | CRUD complet, méthodes renvoyant des `List`, tri, pagination et opérations JPA comme `flush`. |

`JpaRepository` est retenue car elle regroupe le CRUD, les listes, la pagination et les opérations propres à JPA. Les suppressions en lot ne doivent pas être utilisées pour `Contrat`, car elles contournent les cascades et `orphanRemoval`.

| Anomalie | Explication | Correction |
| --- | --- | --- |
| `@Repository` redondant | Spring Data crée déjà le bean pour une interface `JpaRepository`. | Aucune annotation `@Repository` ajoutée. |
| Classe d'implémentation de repository inutile | Spring Data génère un proxy automatiquement. | Les repositories restent des interfaces. |
| `@Data` sur une entité | Risque de boucle avec les associations JPA. | Lombok ciblé (`@Getter`, `@Setter`, etc.) uniquement. |
