public class ServiceStock implements Souscripteur {

    @Override
    public void update(String statut, String reference) {
        if (statut.equals("EXPEDIEE")) {
            System.out.println("  [Stock] Decrementation du stock pour la commande " + reference);
        }
    }
}
