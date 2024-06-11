package it.contrader.view.casa;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.CasaDTO;
import it.contrader.main.AgenziaSingleton;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.Scanner;

public class CasaUpdateView extends AbstractView {

    private int id, agenzia_id;

    private String nome, indirizzo, metri_quadrati, costruita, dettagli, tipo;

    private double prezzo;
    @Override
    public void showResults(Response response) {
        if (response != null){
            System.out.println("Modifica completata");
            Request request = new Request("Casa", "getAll", null);
            MainDispatcher.getInstance().callAction(request);
        }
    }

    @Override
    public void showOptions() {
        try{
           System.out.println("Inserisci l'id della casa da modificare");
            id = Integer.parseInt(getInput());
            System.out.println("Inserisci il nuovo nome della casa");
            nome = getInput();
            System.out.println("Inserisci la nuova proposta di prezzo");
            prezzo = !getInput().isEmpty() ? Double.parseDouble(getInput()) : 0.0;
            System.out.println("Inserisci l'indirizzo");
            indirizzo = getInput();
            System.out.println("Inserisci la nuova metratura");
            metri_quadrati = getInput();
            System.out.println("Inserisci l'anno degli ultimi lavori");
            costruita = getInput();
            System.out.println("Inserisci la nuova descrizione");
            dettagli = getInput();
            System.out.println("Inserisci il nuovo tipo");
            tipo = getInput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void submit() {
        Request request = new Request();
        CasaDTO casaToUpdate = new CasaDTO();
        casaToUpdate.setId(id);
        casaToUpdate.setNome(nome);
        casaToUpdate.setPrezzo(prezzo);
       casaToUpdate.setIndirizzo(indirizzo);
        casaToUpdate.setMetri_quadrati(metri_quadrati);
        casaToUpdate.setCostruita(costruita);
        casaToUpdate.setDettagli(dettagli);
        casaToUpdate.setTipo(tipo);

        casaToUpdate.setAgenzia_id(AgenziaSingleton.getInstance().getId());
        request.getBody().put("casaToUpdate", casaToUpdate);
        request.setMethod("update");
        request.setController("Casa");
        MainDispatcher.getInstance().callAction(request);
    }
}
