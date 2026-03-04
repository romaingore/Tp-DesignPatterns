public class PaiementPayPal implements StrategiePaiement {

    private String email;

    public PaiementPayPal(String email) {
        this.email = email;
    }

    @Override
    public void payer(double montant) {
        System.out.println("  Paiement de " + montant + "€ via PayPal (" + email + ")");
    }
}
