public class PaiementVirement implements StrategiePaiement {

    private String iban;

    public PaiementVirement(String iban) {
        this.iban = iban;
    }

    @Override
    public void payer(double montant) {
        System.out.println("  Paiement de " + montant + "€ par virement bancaire (IBAN : " + iban + ")");
    }
}
