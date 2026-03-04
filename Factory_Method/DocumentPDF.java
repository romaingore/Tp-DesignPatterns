public class DocumentPDF implements Document {

    @Override
    public void generer(String donnees) {
        System.out.println("  [PDF] Mise en page et generation du fichier rapport." + getExtension());
        System.out.println("  [PDF] Contenu : " + donnees);
    }

    @Override
    public String getExtension() {
        return ".pdf";
    }
}
