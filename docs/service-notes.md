# Atelier 4 - IoC, injection de dépendances et couche Service

## A. Modes d'injection comparés

| Critère | Constructeur | Attribut |
| --- | --- | --- |
| Champ `final` possible | Oui | Non |
| Dépendance visible | Oui, dans le constructeur | Non |
| Utilisable hors du conteneur | Oui, en passant la dépendance | Non, la dépendance peut être `null` |
| Signalement SonarQube | Conforme | Règle S6813 : préférer l'injection par constructeur |

Le projet utilise exclusivement l'injection par constructeur, générée avec `@RequiredArgsConstructor` sur les champs `final`.

## B. Services

| Service | Dépendance injectée | Mode | Justification |
| --- | --- | --- | --- |
| `AgenceServiceImpl` | `IAgenceRepository` | Constructeur | Dépendance obligatoire et testable. |
| `EmployeServiceImpl` | `IEmployeRepository` | Constructeur | Dépendance obligatoire et testable. |
| `VehiculeServiceImpl` | `IVehiculeRepository` | Constructeur | Dépendance obligatoire et testable. |
| `EquipementServiceImpl` | `IEquipementRepository` | Constructeur | Dépendance obligatoire et testable. |
| `ClientServiceImpl` | `IClientRepository` | Constructeur | Dépendance obligatoire et testable. |
| `ReservationServiceImpl` | `IReservationRepository` | Constructeur | Dépendance obligatoire et testable. |
| `ContratServiceImpl` | `IContratRepository` | Constructeur | Dépendance obligatoire et testable. |
| `PaiementServiceImpl` | `IPaiementRepository` | Constructeur | Service de lecture seule. |
| `MaintenanceServiceImpl` | `IMaintenanceRepository` | Constructeur | Dépendance obligatoire et testable. |

## C. Messages d'erreur Spring

1. **Service introuvable** : `ContratServiceImpl` peut ne pas avoir `@Service`, ou être placé hors du package `tn.esprit.tp_foyer`. Il faut ajouter l'annotation et vérifier le package.
2. **Deux beans du même type** : utiliser `@Primary` sur l'implémentation choisie par défaut, ou `@Qualifier("nomDuBean")` sur le paramètre du constructeur.
3. **Dépendance circulaire** : l'injection par constructeur rend le cycle visible au démarrage. Il faut extraire la responsabilité partagée dans un troisième service, plutôt que faire dépendre `ClientService` et `ReservationService` l'un de l'autre.

## D. Anomalies SonarQube for IDE

| Règle / anomalie | Explication | Correction appliquée |
| --- | --- | --- |
| S6813 | L'injection par attribut masque la dépendance et empêche le champ `final`. | Injection par constructeur avec `@RequiredArgsConstructor`. |
| S112 | Lever une `RuntimeException` générique est trop imprécis. | Création de `ResourceNotFoundException`. |
| `@Data` sur une entité | Peut déclencher des boucles sur les associations JPA dans `toString` et `equals`. | Lombok ciblé et exclusions sur les associations. |

## E. Questions de compréhension

1. Il n'y a pas de `new ContratServiceImpl(...)` dans le code applicatif : le conteneur Spring crée le bean au démarrage.
2. Le contrôleur dépend de `IContratService` pour dépendre d'une abstraction et faciliter le remplacement ou les tests de l'implémentation.
3. Un singleton partagé doit rester sans état afin d'éviter qu'une requête écrase l'état d'une autre. Exemple : un champ `contratCourant` serait partagé entre les utilisateurs.
4. `update` charge l'entité existante afin de préserver son identifiant et les associations non modifiées, notamment les paiements du contrat.
5. `@Component` annote une classe détectée automatiquement ; `@Bean` déclare un objet depuis une méthode de configuration. `@Primary` choisit le bean par défaut ; `@Qualifier` sélectionne explicitement un bean. `IPaiementService` est en lecture seule car les paiements sont gérés par le contrat.
