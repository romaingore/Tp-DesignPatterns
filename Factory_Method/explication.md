# Factory Method

## Nom du patron

**Factory Method** (Méthode Fabrique) — Patron de **création**

---

## Intention

Le Factory Method définit une interface pour créer un objet, mais laisse les sous-classes décider quelle classe instancier. La création est déléguée aux sous-classes via une méthode que chacune redéfinit.

---

## Problème

Imaginons un outil de génération de rapports. Au départ, il n'exporte qu'en PDF. Le code instancie directement `new DocumentPDF()` partout. Puis on doit ajouter l'export CSV, puis Excel...

Chaque ajout oblige à modifier le code existant : chercher tous les `new DocumentPDF()`, ajouter des `if/else` pour choisir le bon type, risquer de casser ce qui marchait.

De plus, la logique autour de la création (préparer les données, logger, valider) est identique quel que soit le format — mais elle est mélangée avec le choix du type concret.

**Le problème central** : comment centraliser la logique commune de création tout en laissant le choix du type concret ouvert à l'extension ?

---

## Solution

On extrait la création de l'objet dans une **méthode fabrique** (`creerDocument()`) déclarée dans une classe abstraite. La classe abstraite contient toute la logique commune autour de la création. Les sous-classes redéfinissent uniquement la méthode fabrique pour retourner leur propre type de produit.

Le code client travaille avec l'interface du produit — il ne sait jamais quelle classe concrète est instanciée.

---

## Structure (rôles des classes)

| Rôle | Responsabilité |
|---|---|
| **Produit** | Interface commune à tous les objets que la fabrique peut créer |
| **Produits Concrets** | Implémentations spécifiques du Produit |
| **Créateur** | Classe abstraite qui déclare la méthode fabrique et contient la logique métier commune |
| **Créateurs Concrets** | Redéfinissent la méthode fabrique pour retourner un Produit Concret précis |

> Le Créateur appelle sa propre méthode fabrique dans sa logique métier. Il ne sait pas ce que retourne cette méthode — c'est la sous-classe qui le décide.

---

## Applicabilité

Utiliser Factory Method quand :

- **Le type exact de l'objet à créer n'est pas connu à l'avance** et doit pouvoir varier selon le contexte.
- **On veut permettre l'extension sans modifier le code existant** : ajouter un nouveau type = créer une nouvelle sous-classe.
- **La logique autour de la création est commune** mais le produit créé varie — on factorise la logique dans le Créateur abstrait.

---

## Avantages

- **Principe Ouvert/Fermé** : ajouter un nouveau type de produit ne nécessite pas de modifier le Créateur abstrait ni les autres créateurs.
- **Principe de Responsabilité Unique** : la création est centralisée dans les sous-classes ; la logique métier reste dans le Créateur.
- **Découplage** : le code client ne dépend que de l'interface Produit, jamais des classes concrètes.

---

## Inconvénients

- **Multiplication des sous-classes** : chaque nouveau type de produit implique une nouvelle sous-classe Créateur.
- **Peut sembler sur-dimensionné** si la logique autour de la création est triviale et qu'il n'y a que 2 types de produits.

---

## Cas d'usage réel

**Outil de reporting** : un rapport doit pouvoir être exporté en PDF, CSV ou Excel selon le choix de l'utilisateur. La logique de préparation des données est identique quel que soit le format — seul le document généré change.

- Produit : `Document` avec `generer(String donnees)`
- Produits concrets : `DocumentPDF`, `DocumentCSV`, `DocumentExcel`
- Créateur abstrait : `ExportateurRapport` avec la méthode fabrique abstraite `creerDocument()` et la méthode `exporter()` qui l'utilise
- Créateurs concrets : `ExportateurPDF`, `ExportateurCSV`, `ExportateurExcel`

```
ExportateurRapport exportateur = new ExportateurPDF();
exportateur.exporter("CA Q1: 42000, Q2: 51000");
// -> crée un DocumentPDF et le génère
```

Ajouter demain l'export XML ? On crée `DocumentXML` et `ExportateurXML` — rien d'autre n'est touché.

---

## Liens avec d'autres patrons

| Patron | Relation |
|---|---|
| **Fabrique Abstraite** | Souvent implémentée avec des Factory Methods ; va plus loin en gérant des familles de produits |
| **Template Method** | Très proche : Factory Method est souvent un cas particulier de Template Method appliqué à la création d'objets |
| **Prototype** | Alternative au Factory Method : au lieu de sous-classer, on clone un objet existant |
| **Singleton** | Un Créateur Concret peut être un Singleton si une seule instance suffit |
