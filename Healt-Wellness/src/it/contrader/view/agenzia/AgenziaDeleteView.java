package it.contrader.view.agenzia;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.view.user.UserDeleteView;

public class AgenziaDeleteView extends AbstractView {

    private Request request;

    private int id;

    private final String mode = "DELETE";

    public AgenziaDeleteView(){}

    @Override
    public void showResults(Response response) {
        if (response != null){
            System.out.println("Cancellazione completata");
            Request request = new Request("Agenzia", "getAll", null);
            MainDispatcher.getInstance().callAction(request);
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci l'id dell'agenzia da eliminare");
        id = Integer.parseInt(getInput());
    }

    @Override
    public void submit() {
        request = new Request();
        request.getBody().put("id", id);
        request.setController("Agenzia");
        request.setMethod("delete");
        MainDispatcher.getInstance().callAction(request);
    }
}
