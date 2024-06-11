package it.contrader.view.acquisto;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.view.AbstractView;

public class AcquistoInsertView extends AbstractView {

    private Request request;

    private String nome;

    @Override
    public void showResults(Response response) {
        if(response != null) {
            System.out.println("ACQUISTO COMPLETATO \n");
            if (UserSingleton.getInstance().getUsertype().equals("ADMIN")) {
                MainDispatcher.getInstance().callView("HomeAdmin", null);
            }else{
                MainDispatcher.getInstance().callView("HomeUser", null);
            }
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci il nome della casa che vuoi acquistare");
        nome = getInput();
    }

    @Override
    public void submit() {
        request = new Request();
        request.getBody().put("nome", nome);
        request.setController("Acquisto");
        request.setMethod("insert");
        MainDispatcher.getInstance().callAction(request);
    }
}
