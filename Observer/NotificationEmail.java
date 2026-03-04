public class NotificationEmail implements Souscripteur {

    private String destinataire;

    public NotificationEmail(String destinataire) {
        this.destinataire = destinataire;
    }

    @Override
    public void update(String statut, String reference) {
        System.out.println("  [Email -> " + destinataire + "] Votre commande " + reference + " est maintenant : " + statut);
    }
}
