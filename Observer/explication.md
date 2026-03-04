# Observer

## Nom du patron

**Observer** (Observateur) — Patron de **comportement**

---

## Intention

Le patron Observer met en place un mécanisme de souscription permettant à plusieurs objets d'être notifiés automatiquement lorsqu'un événement survient sur un objet qu'ils observent.

---

## Problème

Imaginons un système de suivi de commandes dans une boutique en ligne. Quand une commande change de statut (confirmée, expédiée, livrée), plusieurs services doivent réagir : envoyer un email au client, envoyer un SMS, mettre à jour le stock, notifier le service logistique...

Sans Observer, la classe `Commande` devrait connaître et appeler directement chaque service. Deux problèmes surgissent :

- **Couplage fort** : `Commande` dépend de tous les services. Ajouter un nouveau service oblige à modifier `Commande`.
- **Responsabilité gonflée** : `Commande` ne devrait pas se préoccuper de qui veut être tenu au courant.

**Le problème central** : comment notifier des objets intéressés par un événement, sans que l'objet source sache qui ils sont ?

---

## Solution

L'objet source — le **diffuseur** — maintient une liste de **souscripteurs**. Quand un événement important survient, il appelle une méthode de notification sur chacun d'eux via une **interface commune**.

Les souscripteurs s'inscrivent et se désinscrivent dynamiquement. Le diffuseur ne connaît que l'interface — jamais les classes concrètes. Chaque souscripteur décide lui-même de ce qu'il fait à la réception de la notification.

---

## Structure (rôles des classes)

| Rôle | Responsabilité |
|---|---|
| **Interface Diffuseur** | Déclare les méthodes `subscribe()`, `unsubscribe()` et `notify()` que tout diffuseur doit exposer |
| **Diffuseur Concret** | Implémente l'interface Diffuseur ; maintient la liste des souscripteurs et déclenche `notify()` lors d'un événement |
| **Interface Souscripteur** | Déclare la méthode commune appelée lors d'une notification (ex. `update()`) |
| **Souscripteurs Concrets** | Implémentent `update()` avec leur propre logique de réaction |
| **Client** | Crée le diffuseur et les souscripteurs, et établit les connexions |

> ### Deux façons de transmettre les données aux souscripteurs
>
> **Mode Push (pousser)** : le diffuseur passe directement les données en paramètre de `update()`.
> ```
> update(nouveauStatut)   // le souscripteur reçoit ce dont il a besoin
> ```
> Simple et immédiat, mais le diffuseur décide à l'avance ce qu'il envoie — les souscripteurs reçoivent parfois plus d'infos qu'ils n'en ont besoin.
>
> **Mode Pull (tirer)** : le diffuseur passe une référence à lui-même en paramètre. Chaque souscripteur appelle ensuite les getters qui l'intéressent.
> ```
> update(commande)   // le souscripteur tire ce qu'il veut : commande.getStatut(), commande.getClient()…
> ```
> Plus flexible — chaque souscripteur ne lit que ce dont il a besoin — mais crée un couplage plus fort entre les souscripteurs et la classe du diffuseur.

---

## Applicabilité

Utiliser Observer quand :

- **La modification d'un objet doit déclencher des actions dans d'autres objets**, sans savoir à l'avance combien ils sont ni qui ils sont.
- **Les dépendances entre objets doivent être définies dynamiquement** à l'exécution (inscription / désinscription).
- **Un objet ne doit pas être couplé** aux classes qui réagissent à ses changements.

---

## Avantages

- **Principe Ouvert/Fermé** : on peut ajouter de nouveaux souscripteurs sans modifier le diffuseur.
- **Faible couplage** : le diffuseur ne connaît que l'interface — pas les implémentations concrètes.
- **Relations dynamiques** : les souscripteurs peuvent s'inscrire ou se désinscrire à tout moment pendant l'exécution.
- **Séparation des responsabilités** : chaque souscripteur gère sa propre réaction à l'événement.

---

## Inconvénients

- **Ordre de notification imprévisible** : les souscripteurs sont notifiés dans un ordre non garanti, ce qui peut poser problème si des traitements dépendent les uns des autres.
- **Fuites mémoire possibles** : si un souscripteur oublie de se désinscrire, il reste référencé par le diffuseur et ne peut pas être libéré par le garbage collector.
- **Effets en cascade difficiles à tracer** : une notification peut en déclencher d'autres, rendant le flux d'exécution difficile à suivre et à déboguer.

---

## Cas d'usage réel

**Suivi de commande e-commerce** : quand une commande passe au statut "expédiée", plusieurs services doivent réagir indépendamment.

- Interface : `SouscripteurCommande` avec une méthode `update(statut)`
- Souscripteurs concrets :
  - `NotificationEmail` — envoie un email de confirmation au client
  - `NotificationSMS` — envoie un SMS avec le numéro de suivi
  - `ServiceStock` — décrémente le stock des articles expédiés
  - `ServiceLogistique` — génère le bon de transport
- Diffuseur : `Commande` qui notifie tous les souscripteurs à chaque changement de statut
- Client : le système qui crée la commande et branche les services souhaités

Demain on ajoute une intégration Slack pour alerter l'équipe ? On crée `NotificationSlack`, on l'inscrit — la classe `Commande` n'est pas touchée.

---

