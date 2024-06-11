package it.contrader.view.anagrafica;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.view.AbstractView;

public class AnagraficaReadView extends AbstractView {


    @Override
    public void showResults(Response response) {
        if(response != null){
            System.out.println("Cognome\tNome\temail\tDataNascita\tGenere\tNazione\tProvincia\tCitta\tIndirizzo");
            System.out.println("----------------------------------------------------\n");
            System.out.println(response.getBody().get("anagrafica").toString());
            if(UserSingleton.getInstance().getUsertype().equals("ADMIN")){
                MainDispatcher.getInstance().callView("HomeAdmin", null);
            } else{
                MainDispatcher.getInstance().callView("HomeUser", null);
            }
        }


    }

    @Override
    public void showOptions() {
        System.out.println("DATI PERSONALI: ");
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.setController("Anagrafica");
        request.setMethod("read");
        request.getBody().put("idUser", UserSingleton.getInstance().getId());
        MainDispatcher.getInstance().callAction(request);
    }
}
