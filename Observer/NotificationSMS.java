public class NotificationSMS implements Souscripteur {

    private String telephone;

    public NotificationSMS(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public void update(String statut, String reference) {
        System.out.println("  [SMS -> " + telephone + "] Commande " + reference + " : " + statut);
    }
}
