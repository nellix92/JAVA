package it.contrader.view.anagrafica;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.view.AbstractView;

public class AnagraficaUpdateView extends AbstractView {

    public AnagraficaUpdateView() {
    }

    int idUser;
    String cognome, nome, email, dataDiNascita, genere, nazione, provincia, citta, indirizzo;

    @Override
    public void showResults(Response response) {
        if (response != null) {
            System.out.println("Modifica andata a buon fine.\n");
            if (UserSingleton.getInstance().getUsertype().equals("ADMIN")) {
                MainDispatcher.getInstance().callView("HomeAdmin", null);
            } else {
                MainDispatcher.getInstance().callView("HomeUser", null);
            }
        }

    }

    @Override
    public void showOptions() {

        try {
            idUser = UserSingleton.getInstance().getId();
            System.out.println("Inserisci il nuovo cognome:");
            cognome = getInput();
            System.out.println("Inserisci il nuovo nome:");
            nome = getInput();
            System.out.println("Inserisci la nuova email:");
            email = getInput();
            System.out.println("Inserisci il nuovo datadinascita:");
            dataDiNascita = getInput();
            System.out.println("Inserisci il nuovo genere:");
            genere = getInput();
            System.out.println("Inserisci il nuovo nazione:");
            nazione = getInput();
            System.out.println("Inserisci il nuovo provincia:");
            provincia = getInput();
            System.out.println("Inserisci il nuovo citta:");
            citta = getInput();
            System.out.println("Inserisci il nuovo indirizzo:");
            indirizzo = getInput();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void submit() {

        Request request = new Request();
        AnagraficaDTO anagraficaToUpdate = new AnagraficaDTO(cognome, nome, email, dataDiNascita, genere, nazione, provincia, citta, indirizzo, idUser);
        request.getBody().put("anagraficaToUpdate", anagraficaToUpdate);
        request.setMethod("update");
        request.setController("Anagrafica");
        MainDispatcher.getInstance().callAction(request);
    }
}
