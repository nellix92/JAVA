package it.contrader.view.casa;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.CasaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CasaInsertView extends AbstractView {

    private int id, agenzia_id;

    private String nome, indirizzo, metri_quadrati, costruita, dettagli, tipo;

    private double prezzo;


    @Override
    public void showResults(Response response) {
        if (response != null){
            System.out.println("\n CREAZIONE CASA COMPLETATA");
            Request request = new Request("Casa", "getAll", null);
            MainDispatcher.getInstance().callView("HomeAdmin", null);
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci il nome della tua casa: ");
        this.nome = getInput();
        System.out.println("Inserisci l'indirizzo della tua casa: ");
        this.indirizzo = getInput();
        System.out.println("Inserisci la metratura: ");
        this.metri_quadrati = getInput();
        System.out.println("Inserisci l'anno degli ultimi lavori effettuati: ");
        this.costruita = getInput();
        System.out.println("Aggiungi una descrizione: ");
        this.dettagli = getInput();
        System.out.println("Che tipo di casa è?");
        this.tipo = getInput();
        System.out.println("Qual è il prezzo?");
        this.prezzo = Double.parseDouble(getInput());
        System.out.println("Per conto di quale agenzia?");
        this.agenzia_id = Integer.parseInt(getInput());
    }

    @Override
    public void submit() {
        Request request = new Request();
        CasaDTO casaToInsert = new CasaDTO(nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, agenzia_id);
        request.getBody().put("casaToInsert", casaToInsert);
        request.setMethod("insert");
        request.setController("Casa");
        MainDispatcher.getInstance().callAction(request);
    }
}
