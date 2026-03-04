public class ExportateurExcel extends ExportateurRapport {

    @Override
    public Document creerDocument() {
        return new DocumentExcel();
    }
}
