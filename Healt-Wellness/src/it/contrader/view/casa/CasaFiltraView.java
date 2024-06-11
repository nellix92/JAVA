package it.contrader.view.casa;

import com.sun.tools.javac.Main;
import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CasaFiltraView extends AbstractView {
    private int id, agenzia_id;

    private String nome, indirizzo, metri_quadrati, costruita, dettagli, tipo;

    private double prezzo;

    private String scelta;

    private static String sub_package = "casa.";

    @Override
    public void showResults(Response response) {

    }

    @Override
    public void showOptions() {
        System.out.println("----------------Come vuoi filtrare le case?------------");
        System.out.print("[1] - Tipo ");
        System.out.print("[2] - Prezzo ");
        System.out.print("[3] - Nome ");
        System.out.print("[4] - Metri Quadrati ");

        scelta = getInput();

    }

    @Override
    public void submit() {
        switch (scelta) {
            case "1":
                MainDispatcher.getInstance().callView(sub_package + "CasaFiltroTipo", null);
                break;
            case "2":
                MainDispatcher.getInstance().callView(sub_package + "CasaFiltraPrezzo", null);
                break;
            case "3":
                MainDispatcher.getInstance().callView(sub_package + "CasaFiltraNome", null);
                break;
            case "4":
                MainDispatcher.getInstance().callView(sub_package + "CasaFiltroMetri", null);
                break;
            default:
                System.out.print("\nOperazione non valida:");
                Request request = new Request("Casa", "getAll", null);
                MainDispatcher.getInstance().callAction(request);
        }
    }
}
