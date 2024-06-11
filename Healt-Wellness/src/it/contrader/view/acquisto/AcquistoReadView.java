package it.contrader.view.acquisto;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AcquistoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AcquistoReadView extends AbstractView {

    private int id;

    @Override
    public void showResults(Response response) {
        if(response != null){
            AcquistoDTO acquisto = (AcquistoDTO) response.getBody().get("acquisto");
            System.out.println(acquisto);
            Request request = new Request("Acquisto", "getAll", null);
            MainDispatcher.getInstance().callAction(request);
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci l'id dell'acquisto che stai cercando");
        id = Integer.parseInt(getInput());
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.getBody().put("id", id);
        request.setController("Acquisto");
        request.setMethod("read");
        MainDispatcher.getInstance().callAction(request);
    }
}
