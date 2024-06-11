package it.contrader.view.agenzia;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AgenziaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AgenziaInsertView extends AbstractView {

    private int id;
    private String nome, provincia, citta, indirizzo, descrizione;

    private int admin_id;


    @Override
    public void showResults(Response response) {
        if (response != null) {
            System.out.println("\n CREAZIONE AGENZIA COMPLETATA");
            Request request = new Request("Agenzia", "getAll", null);
            MainDispatcher.getInstance().callView("HomeAdmin", null);
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci il nome della tua agenzia: ");
        this.nome = getInput();
        System.out.println("Inserisci la descrizione della tua agenzia: ");
        this.descrizione = getInput();
        System.out.println("Inserisci la provincia della tua agenzia: ");
        this.provincia = getInput();
        System.out.println("Inserisci la città in cui si trova la tua agenzia: ");
        this.citta = getInput();
        System.out.println("Inserisci l'indirizzo della tua agenzia: ");
        this.indirizzo = getInput();
        System.out.println("Chi è il titolare dell'agenzia?");
        this.admin_id = Integer.parseInt(getInput());
    }

    @Override
    public void submit() {
        Request request = new Request();
        AgenziaDTO agenziaToInsert = new AgenziaDTO(nome, descrizione, provincia, citta, indirizzo, admin_id);
        request.getBody().put("agenziaToInsert", agenziaToInsert);
        request.setMethod("insert");
        request.setController("Agenzia");
        MainDispatcher.getInstance().callAction(request);
    }
}
