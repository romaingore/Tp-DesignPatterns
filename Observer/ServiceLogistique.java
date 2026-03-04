public class ServiceLogistique implements Souscripteur {

    @Override
    public void update(String statut, String reference) {
        if (statut.equals("EXPEDIEE")) {
            System.out.println("  [Logistique] Bon de transport genere pour la commande " + reference);
        }
    }
}
