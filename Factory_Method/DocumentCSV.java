public class DocumentCSV implements Document {

    @Override
    public void generer(String donnees) {
        System.out.println("  [CSV] Serialisation des donnees en colonnes dans rapport" + getExtension());
        System.out.println("  [CSV] Contenu : " + donnees);
    }

    @Override
    public String getExtension() {
        return ".csv";
    }
}
