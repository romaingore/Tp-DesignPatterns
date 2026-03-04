public abstract class ExportateurRapport {

    // La methode fabrique : les sous-classes decident quel Document creer
    public abstract Document creerDocument();

    // Logique metier commune : identique quel que soit le format
    public void exporter(String donnees) {
        System.out.println("Preparation des donnees...");
        Document doc = creerDocument();
        System.out.println("Export en cours (format " + doc.getExtension() + ")...");
        doc.generer(donnees);
        System.out.println("Export termine.");
    }
}
