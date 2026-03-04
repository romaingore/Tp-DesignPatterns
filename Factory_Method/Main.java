public class Main {
    public static void main(String[] args) {
        String donnees = "CA Q1: 42000, Q2: 51000, Q3: 47000, Q4: 63000";

        // Export PDF
        ExportateurRapport exportateur = new ExportateurPDF();
        exportateur.exporter(donnees);

        System.out.println();

        // Export CSV — on change le createur, la logique commune reste identique
        exportateur = new ExportateurCSV();
        exportateur.exporter(donnees);

        System.out.println();

        // Export Excel
        exportateur = new ExportateurExcel();
        exportateur.exporter(donnees);
    }
}
