package it.contrader.view.agenzia;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AgenziaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AgenziaReadView extends AbstractView {

    private int id;
    @Override
    public void showResults(Response response) {
        if (response != null){
            AgenziaDTO agenzia = (AgenziaDTO) response.getBody().get("agenzia");
            System.out.println(agenzia);
            Request request = new Request("Agenzia", "getAll", null);
            MainDispatcher.getInstance().callAction(request);
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci l'ID dell'Agenzia che stai cercando");
        id = Integer.parseInt(getInput());
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.getBody().put("id", id);
        request.setController("Agenzia");
        request.setMethod("read");
        MainDispatcher.getInstance().callAction(request);
    }
}
