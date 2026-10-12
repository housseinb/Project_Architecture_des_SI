# Stratégie Fetch et Cascade - Atelier 2

| Association | Fetch | Cascade | Justification |
| --- | --- | --- | --- |
| Contrat → Paiement | LAZY | ALL + orphanRemoval | Un paiement dépend de son contrat. La suppression du contrat ou le retrait d'un paiement de la collection supprime le paiement concerné. |
| Agence → Véhicule | LAZY | Aucune | Un véhicule peut continuer à exister si son agence est supprimée. |
| Agence → Employé | LAZY | Aucune | Le cycle de vie d'un employé n'est pas propagé par celui de son agence. |
| Véhicule ↔ Équipement | LAZY | Aucune | Les équipements peuvent être partagés entre plusieurs véhicules. |
| Client → Réservation | LAZY | PERSIST | L'enregistrement d'un client peut enregistrer ses nouvelles réservations, sans propager les suppressions. |
| Réservation → Véhicule | LAZY | Aucune | Un véhicule possède son propre cycle de vie. |
| Réservation ↔ Contrat | LAZY | ALL côté Reservation | Le contrat est associé à sa réservation et les opérations de la réservation se propagent au contrat. |
| Véhicule → Maintenance | LAZY | PERSIST | L'enregistrement d'un véhicule peut enregistrer ses nouvelles maintenances, sans supprimer l'historique par cascade. |

Toutes les associations sont déclarées en `LAZY` afin de ne charger les objets associés que lorsque le code en a besoin.
