public class Main {
    public static void main(String[] args) {
        Commande commande = new Commande("CMD-2024-001");

        // Inscription des souscripteurs
        NotificationSMS sms = new NotificationSMS("+33 6 12 34 56 78");
        commande.subscribe(new NotificationEmail("client@email.com"));
        commande.subscribe(sms);
        commande.subscribe(new ServiceStock());
        commande.subscribe(new ServiceLogistique());

        // Changements de statut : chaque changement notifie tous les souscripteurs
        commande.changerStatut("CONFIRMEE");
        commande.changerStatut("EXPEDIEE");

        // Desinscription d'un souscripteur en cours d'execution
        System.out.println("\nLe client desactive les SMS...");
        commande.unsubscribe(sms);

        commande.changerStatut("LIVREE");
    }
}
