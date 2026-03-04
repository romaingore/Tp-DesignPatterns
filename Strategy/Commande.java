public class Commande {

    private String produit;
    private double montant;
    private StrategiePaiement strategie;

    public Commande(String produit, double montant, StrategiePaiement strategie) {
        this.produit = produit;
        this.montant = montant;
        this.strategie = strategie;
    }

    public void setStrategie(StrategiePaiement strategie) {
        this.strategie = strategie;
    }

    public void valider() {
        System.out.println("Commande : " + produit + " (" + montant + "€)");
        strategie.payer(montant);
    }
}
