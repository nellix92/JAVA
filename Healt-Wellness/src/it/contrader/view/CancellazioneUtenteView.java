package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;

public class CancellazioneUtenteView extends AbstractView{

    private Request request;

    private String choice;
    private final String mode = "DELETE";

    public CancellazioneUtenteView() {
    }
    @Override
    public void showResults(Response response) {
        if (response != null) {
            System.out.println("Cancellazione andata a buon fine.\n");
            MainDispatcher.getInstance().callView("Login", null);
        }

    }

    @Override
    public void showOptions() {
        System.out.println("Sicuro di voler cancellare?:");
        System.out.println("[S]i    [N]o");

        choice = getInput().toUpperCase();

    }

    @Override
    public void submit() {
        if(choice.equals("S")){
            request = new Request();
            request.getBody().put("id", UserSingleton.getInstance().getId());
            request.setController("User");
            request.setMethod("delete2");
            MainDispatcher.getInstance().callAction(request);
        }else{
            if(UserSingleton.getInstance().getUsertype().equals("ADMIN")){
                MainDispatcher.getInstance().callView("HomeAdmin", null);
            } else{
                MainDispatcher.getInstance().callView("HomeUser", null);
            }
        }

    }
}
