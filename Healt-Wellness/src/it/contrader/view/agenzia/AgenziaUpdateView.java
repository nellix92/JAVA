package it.contrader.view.agenzia;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AgenziaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AgenziaUpdateView extends AbstractView {

    private int id;

    private String nome, descrizione, provincia, citta, indirizzo;


    @Override
    public void showResults(Response response) {
        if (response != null){
            System.out.println("Modifica completata");
            Request request = new Request("Agenzia", "getAll", null);
            MainDispatcher.getInstance().callAction(request);
        }
    }

    @Override
    public void showOptions() {
        try{
            System.out.println("Inserisci l'id dell'agenzia da modificare");
            id = Integer.parseInt(getInput());
            System.out.println("Inserisci il nuovo nome dell'agenzia");
            nome = getInput();
            System.out.println("Inserisci la nuova descrizione della tua agenzia");
            descrizione = getInput();
            System.out.println("Inserisci la nuova provincia della tua azienda");
            provincia = getInput();
            System.out.println("Inserisci la nuova città della tua agenzia");
            citta = getInput();
            System.out.println("Inserisci il nuovo indirizzo della tua agenzia");
            indirizzo = getInput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void submit() {
        Request request = new Request();
        AgenziaDTO agenziaToUpdate = new AgenziaDTO();
        agenziaToUpdate.setId(id);
        agenziaToUpdate.setNome(nome);
        agenziaToUpdate.setDescrizione(descrizione);
        agenziaToUpdate.setProvincia(provincia);
        agenziaToUpdate.setCitta(citta);
        agenziaToUpdate.setIndirizzo(indirizzo);
        request.getBody().put("agenziaToUpdate", agenziaToUpdate);
        request.setMethod("update");
        request.setController("Agenzia");
        MainDispatcher.getInstance().callAction(request);
    }
}
