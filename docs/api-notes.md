# Atelier 5 - API REST et SpringDoc

## A. Endpoints

Les ressources CRUD exposent `GET /api/<ressource>`, `GET /api/<ressource>/{id}`, `POST /api/<ressource>`, `PUT /api/<ressource>/{id}` et `DELETE /api/<ressource>/{id}`. Les services appelés sont les interfaces `I…Service` correspondantes. Les succès renvoient respectivement `200`, `200`, `201`, `200` et `204`; une ressource absente renvoie `404` et une règle métier invalide renvoie `400`.

Ressources CRUD : `agences`, `employes`, `vehicules`, `equipements`, `clients`, `reservations`, `contrats` et `maintenances`. `paiements` n'expose que `GET /api/paiements` et `GET /api/paiements/{id}`.

## B. Annotations Jackson

`Contrat.paiements` utilise `@JsonManagedReference("contrat-paiements")` et `Paiement.contrat` utilise `@JsonBackReference("contrat-paiements")`. Cette paire évite une boucle JSON tout en permettant la création des paiements depuis le contrat. Les collections inverses sans composition (`Agence.vehicules`, `Client.reservations`, etc.) utilisent `@JsonIgnore` : elles ne sont pas incluses dans la réponse JSON. `@JsonBackReference` coupe une relation parent-retour précise ; `@JsonIgnore` masque totalement la propriété.

## C. Postman et Swagger

Postman sert à rejouer et vérifier des scénarios, par exemple un `POST /api/agences` suivi d'un `GET /api/agences/{id}`. Swagger UI est la documentation exploratoire générée par SpringDoc : elle est disponible sur `/api/swagger-ui.html`, tandis que le document OpenAPI est sur `/api/v3/api-docs`.

## D. Anomalies SonarQube

| Anomalie | Correction |
| --- | --- |
| Injection par attribut | Injection par constructeur avec champ `final` et `@RequiredArgsConstructor`. |
| Exception générique | `ResourceNotFoundException` est traduite en réponse HTTP 404. |
| Boucle JSON entre entités | Annotations Jackson ciblées sur les associations bidirectionnelles. |

## E. Questions de compréhension

1. `DispatcherServlet` reçoit les requêtes et sélectionne la méthode grâce aux annotations de mapping.
2. Un contrôleur dépend de `I…Service` afin de respecter l'abstraction et de ne pas dépendre directement du repository ou d'une implémentation.
3. `POST` crée une ressource (`201`), `DELETE` ne renvoie pas de corps (`204`), et l'exception métier d'absence est convertie en `404`.
4. Les paiements sont créés et supprimés via le contrat : un `POST /api/paiements` reçoit donc `405 Method Not Allowed`.
5. Exposer les entités JPA peut révéler des champs internes et provoquer des boucles ou des problèmes avec les proxys LAZY. Les DTO remplaceront cette exposition directe plus tard.
