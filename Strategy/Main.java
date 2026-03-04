public class Main {
    public static void main(String[] args) {
        // Paiement par carte bancaire
        Commande commande1 = new Commande("Laptop", 999.99, new PaiementCarteBancaire("1234567890123456"));
        commande1.valider();

        System.out.println();

        // Paiement via PayPal
        Commande commande2 = new Commande("Clavier mecanique", 129.90, new PaiementPayPal("client@email.com"));
        commande2.valider();

        System.out.println();

        // Changement de strategie a la volee sur la meme commande
        System.out.println("Le client change de moyen de paiement...");
        commande2.setStrategie(new PaiementVirement("FR76 3000 6000 0112 3456 7890 189"));
        commande2.valider();
    }
}
