public class ExportateurCSV extends ExportateurRapport {

    @Override
    public Document creerDocument() {
        return new DocumentCSV();
    }
}
