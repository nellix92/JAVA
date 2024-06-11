package it.contrader.view.acquisto;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AcquistoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AcquistoUpdateView extends AbstractView {

    private int id, user_id, casa_id;
    private String nome;
    private double prezzo;


    @Override
    public void showResults(Response response) {
        if (response != null){
            System.out.println("Modifica Acquisto completata");
            Request request = new Request("Acquisto", "getAll", null);
            MainDispatcher.getInstance().callAction(request);
        }
    }

    public void showOptions() {
        try{
            System.out.println("Inserisci l'id delL'ACQUISTO da modificare");
            id = Integer.parseInt(getInput());
            System.out.println("Inserisci il nuovo nome della casa");
            nome = getInput();
            System.out.println("Inserisci la nuova proposta di prezzo");
            prezzo = Double.parseDouble(getInput());
            System.out.println("Inserisci l'id della USER che ha comprato queasta casa");
            user_id = Integer.parseInt(getInput());
            System.out.println("Inserisci l'id della CASA ordinata");
            casa_id = Integer.parseInt(getInput());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void submit() {
        Request request = new Request();
        AcquistoDTO acquistoToUpdate = new AcquistoDTO();
        acquistoToUpdate.setId(id);
        acquistoToUpdate.setNome(nome);
        acquistoToUpdate.setPrezzo(prezzo);
        acquistoToUpdate.setUser_id(user_id);
        acquistoToUpdate.setCasa_id(casa_id);
        request.getBody().put("acquistoToUpdate", acquistoToUpdate);
        request.setMethod("update");
        request.setController("Acquisto");
        MainDispatcher.getInstance().callAction(request);
    }
}
