package it.contrader.view.anagrafica;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AnagraficaInsertView extends AbstractView {

    private String cognome;
    private String nome;
    private String email;
    private String dataDiNascita;
    private String genere;
    private String nazione;
    private String provincia;
    private String citta;
    private String indirizzo;
    private int idUser;


    @Override
    public void showResults(Response response) {
        if (response != null) {
            idUser = (int) response.getBody().get("id");

        }
    }

        @Override
        public void showOptions () {
            System.out.println("Inserisci il tuo cognome: ");
            this.cognome = getInput();
            System.out.println("Inserisci il tuo nome: ");
            this.nome = getInput();
            System.out.println("Inserisci la tua email: ");
            this.email = getInput();
            System.out.println("Inserisci la tua data di nascita: ");
            this.dataDiNascita = getInput();
            System.out.println("Qual è il tuo genere: [Donna], [Uomo], [ALTRO]?");
            this.genere = getInput().toUpperCase();
            System.out.println("Inserisci la nazione di residenza: ");
            this.nazione = getInput();
            System.out.println("Inserisci la provincia di residenza: ");
            this.provincia = getInput();
            System.out.println("Inserisci la città di residenza: ");
            this.citta = getInput();
            System.out.println("Inserisci l'indirizzo di residenza: ");
            this.indirizzo = getInput();
        }

        @Override
        public void submit () {

            Request request = new Request();
            AnagraficaDTO anagraficaToInsert = new AnagraficaDTO(cognome, nome, email, genere, dataDiNascita, nazione, provincia, citta, indirizzo, idUser);
            request.getBody().put("anagraficaToInsert", anagraficaToInsert);
            request.setMethod("registerAnagrafica");
            request.setController("Anagrafica");
            MainDispatcher.getInstance().callAction(request);

        }
    }
