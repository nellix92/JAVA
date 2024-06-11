package it.contrader.view.acquisto;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AcquistoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.List;

public class AcquistoReadAgenziaView extends AbstractView {

    private int id;

    @Override
    public void showResults(Response response) {
        if(response != null){
            System.out.println("\n------------------- Case VENDUTE ----------------\n");

            List<AcquistoDTO> acquisti = (List<AcquistoDTO>) response.getBody().get("acquisto");
            for (AcquistoDTO a : acquisti)
                System.out.println(a);
            System.out.println();
            MainDispatcher.getInstance().callView("HomeAdmin", null);
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci l'id dell'agenzia di cui vuoi visualizzare le vendite");
        id = Integer.parseInt(getInput());
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.getBody().put("id", id);
        request.setMethod("getByAgenzia");
        request.setController("Acquisto");
        MainDispatcher.getInstance().callAction(request);
    }
}
