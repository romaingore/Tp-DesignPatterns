public class PaiementCarteBancaire implements StrategiePaiement {

    private String numeroCarte;

    public PaiementCarteBancaire(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    @Override
    public void payer(double montant) {
        String derniers = numeroCarte.substring(numeroCarte.length() - 4);
        System.out.println("  Paiement de " + montant + "€ par carte bancaire (**** " + derniers + ")");
    }
}
