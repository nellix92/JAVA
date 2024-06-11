package it.contrader.view.casa;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.CasaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CasaReadView extends AbstractView {

    private int id;
    @Override
    public void showResults(Response response) {
        if (response != null){
            CasaDTO casa = (CasaDTO) response.getBody().get("casa");
            System.out.println(casa);
            Request request = new Request("Casa", "getAll", null);
            MainDispatcher.getInstance().callAction(request);
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci l'ID della Casa che stai cercando");
        String input = getInput();
        if(isNumeric(input)){
            id = Integer.parseInt(input);
        }else{
            System.out.println("Inserisci un id valido");
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.getBody().put("id", id);
        request.setController("Casa");
        request.setMethod("read");
        MainDispatcher.getInstance().callAction(request);
    }
}
