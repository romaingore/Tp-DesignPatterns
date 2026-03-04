public class DocumentExcel implements Document {

    @Override
    public void generer(String donnees) {
        System.out.println("  [Excel] Generation du classeur avec graphiques dans rapport" + getExtension());
        System.out.println("  [Excel] Contenu : " + donnees);
    }

    @Override
    public String getExtension() {
        return ".xlsx";
    }
}
