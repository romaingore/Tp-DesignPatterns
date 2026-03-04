# TP Design Patterns

## Langage utilise
Java

## Structure du projet
```
/Factory_Method
    explication.md
    Document.java
    DocumentPDF.java
    DocumentCSV.java
    DocumentExcel.java
    ExportateurRapport.java
    ExportateurPDF.java
    ExportateurCSV.java
    ExportateurExcel.java
    Main.java

/Observer
    explication.md
    Diffuseur.java
    Souscripteur.java
    Commande.java
    NotificationEmail.java
    NotificationSMS.java
    ServiceStock.java
    ServiceLogistique.java
    Main.java

/Strategy
    explication.md
    StrategiePaiement.java
    PaiementCarteBancaire.java
    PaiementPayPal.java
    PaiementVirement.java
    Commande.java
    Main.java

/Decorator
    explication.md
    diagrammeClasse.png
    Pizza.java
    PizzaMargarita.java
    DecoratorIngredient.java
    AvecJambon.java
    AvecChampignons.java
    AvecOlives.java
    AvecFromage.java
    Main.java
```

## Comment executer les exemples
Chaque dossier contient un fichier `Main.java` qui sert de script de demonstration.

Pour compiler et executer un exemple :
```bash
cd <NomDuPattern>
javac *.java
java Main
```
