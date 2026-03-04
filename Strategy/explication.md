# Strategy

## Nom du patron

**Strategy** (Stratégie) — Patron de **comportement**

---

## Intention

Le patron Strategy permet de définir une famille d'algorithmes, de les placer dans des classes distinctes et de les rendre interchangeables. Il permet à un objet de modifier son comportement en changeant simplement l'algorithme qu'il utilise, sans toucher à sa propre structure.

---

## Problème

Imaginons une boutique en ligne. Au départ, elle accepte uniquement le paiement par carte bancaire. Puis on ajoute PayPal, ensuite le virement bancaire, puis le paiement en cryptomonnaie...

À chaque nouveau moyen de paiement, on modifie la classe `Commande`. Elle grossit, devient difficile à lire et à maintenir. Le code est truffé de blocs `if/else` ou `switch` pour choisir la logique de paiement. Travailler à plusieurs sur cette classe provoque des conflits constants.

**Le problème central** : des comportements qui varient sont enfermés dans une classe qui ne devrait pas changer.

---

## Solution

Extraire chaque variante d'algorithme dans sa propre classe, appelée **stratégie concrète**. Ces classes partagent toutes une interface commune — l'**interface Stratégie**.

La classe originale, le **Contexte**, ne connaît que cette interface. Elle garde une référence vers une stratégie et lui délègue le travail. Le client choisit quelle stratégie passer au contexte.

Résultat : le Contexte est indépendant des implémentations concrètes. On peut ajouter une nouvelle stratégie sans toucher au Contexte.

---

## Structure (rôles des classes)

| Rôle | Responsabilité |
|---|---|
| **Interface Stratégie** | Déclare la méthode commune à tous les algorithmes (ex. `execute()`) |
| **Stratégies Concrètes** | Implémentent chacune une variante de l'algorithme |
| **Contexte** | Garde une référence vers une stratégie ; lui délègue le travail via l'interface |
| **Client** | Crée l'objet stratégie approprié et le passe au Contexte |

> Le Contexte appelle la méthode de la stratégie quand il en a besoin. Il ne sait pas à quelle stratégie concrète il parle — seulement qu'elle respecte l'interface.

---

## Applicabilité

Utiliser Strategy quand :

- **On a plusieurs variantes d'un algorithme** à utiliser selon le contexte (ex. différents moyens de paiement, modes de tri, calculs de prix).
- **On veut supprimer les grands blocs conditionnels** (`if/else`, `switch`) qui sélectionnent le comportement.
- **On veut isoler la logique métier** de l'implémentation algorithmique.
- **On veut pouvoir changer d'algorithme à l'exécution**, sans recréer l'objet.

---

## Avantages

- **Permutation à l'exécution** : on peut changer la stratégie d'un objet dynamiquement, sans le recréer.
- **Principe Ouvert/Fermé** : on peut ajouter une nouvelle stratégie sans modifier le Contexte.
- **Composition plutôt qu'héritage** : évite l'explosion de sous-classes (`CommandeCarteBancaire`, `CommandePayPal`, etc.).
- **Isolation** : chaque algorithme est dans sa propre classe, plus facile à lire, tester, et modifier.
- **Suppression des conditionnels** : fini les `if/else` à rallonge dans la classe principale.

---

## Inconvénients

- **Surcharge si peu d'algorithmes** : pour seulement 2 stratégies qui ne changent jamais, le pattern ajoute une complexité inutile.
- **Le client doit connaître les stratégies** : c'est lui qui choisit laquelle passer au Contexte — il doit donc savoir ce qui les différencie.
- **Multiplication des classes** : chaque algorithme devient une classe, ce qui peut alourdir le projet pour des cas simples.
- **Alternative fonctionnelle** : dans les langages modernes (JavaScript, Python…), on peut simplement passer une fonction/lambda en paramètre au lieu de créer des classes dédiées.

---

## Cas d'usage réel

**Boutique en ligne** : au moment de valider son panier, l'utilisateur choisit son moyen de paiement. La logique de traitement est différente selon le choix : appel à une API bancaire, redirection vers PayPal, génération d'un RIB pour virement...

- Interface : `StrategiePaiement` avec une méthode `payer(montant)`
- Stratégies concrètes : `PaiementCarteBancaire`, `PaiementPayPal`, `PaiementVirement`
- Contexte : `Commande` qui délègue le paiement à la stratégie choisie
- Client : l'utilisateur (ou l'UI du panier) qui sélectionne le moyen de paiement

Ajouter demain le paiement en cryptomonnaie ? On crée `PaiementCrypto`, on l'injecte — la classe `Commande` n'est pas touchée.

---
