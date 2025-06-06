# tp3
# TP3 - Tests d'Intégration

## Description
Ce projet contient les implémentations et tests d'intégration pour le TP3 sur l'assurance qualité logicielle. Les trois exercices couvrent :
1. **Exercice 1** : Interaction simple entre `UserService` et `UserRepository`.
2. **Exercice 2** : Interaction avec une base de données simulée via `OrderController`, `OrderService`, et `OrderDao`.
3. **Exercice 3** : Intégration avec une API externe via `ProductService` et `ProductApiClient`.

## Structure du projet
- `src/main/java/com/example/` : Contient les classes et interfaces.
- `src/test/java/com/example/` : Contient les tests JUnit.
- `pom.xml` : Configuration Maven avec JUnit 5 et Mockito.

## Réponses aux questions
### Exercice 1
- **Implémentation** : Une classe `UserService` appelle `UserRepository.findUserById`. Les tests utilisent Mockito pour mocker `UserRepository` et vérifier les interactions.
- **Résultat** : Les tests passent, confirmant que `findUserById` est appelée avec le bon argument.

### Exercice 2
- **Implémentation** : `OrderController` appelle `OrderService.createOrder`, qui utilise `OrderDao.saveOrder`. Les tests mockent `OrderService` pour vérifier les appels.
- **Résultat** : Les tests confirment que `createOrder` est appelée correctement.

### Exercice 3
- **Implémentation** : `ProductService` appelle `ProductApiClient.getProduct`. Les tests mockent `ProductApiClient` pour simuler trois scénarios : succès, format invalide, et échec d’API.
- **Résultat** : Les tests couvrent tous les cas et vérifient les interactions.

## Comment exécuter
1. Clonez le repository.
2. Ouvrez le projet dans IntelliJ IDEA.
3. Exécutez `mvn test` pour lancer les tests.

## Dépendances
- Java 11
- JUnit 5.10.0
- Mockito 5.12.0