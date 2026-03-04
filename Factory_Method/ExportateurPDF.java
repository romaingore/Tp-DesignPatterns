public class ExportateurPDF extends ExportateurRapport {

    @Override
    public Document creerDocument() {
        return new DocumentPDF();
    }
}
