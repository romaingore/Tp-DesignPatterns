import java.util.ArrayList;
import java.util.List;

public class Commande implements Diffuseur {

    private List<Souscripteur> souscripteurs = new ArrayList<>();
    private String reference;
    private String statut;

    public Commande(String reference) {
        this.reference = reference;
        this.statut = "EN_ATTENTE";
    }

    @Override
    public void subscribe(Souscripteur s) {
        souscripteurs.add(s);
    }

    @Override
    public void unsubscribe(Souscripteur s) {
        souscripteurs.remove(s);
    }

    @Override
    public void notifier() {
        for (Souscripteur s : souscripteurs) {
            s.update(statut, reference);
        }
    }

    public void changerStatut(String nouveauStatut) {
        this.statut = nouveauStatut;
        System.out.println("\n[Commande " + reference + "] Statut -> " + statut);
        notifier();
    }

    public String getStatut() { return statut; }
    public String getReference() { return reference; }
}
