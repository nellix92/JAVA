package it.contrader.view;


import com.sun.tools.javac.Main;
import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AcquistoDTO;
import it.contrader.dto.AgenziaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;

import java.util.List;

public class AcquistoView extends AbstractView {

    private String choice;

    private static String sub_package = "acquisto.";

    @Override
    public void showResults(Response response) {
        if(response != null) {
            if(UserSingleton.getInstance().getUsertype().equals("ADMIN")) {
                System.out.println("\n ------------------ Elenco Acquisti ------------------ \n");
                System.out.println("Dettagli Acquisti");

                List<AcquistoDTO> acquistoDTOList = (List<AcquistoDTO>) response.getBody().get("acquisto");

                if (!acquistoDTOList.isEmpty()) {
                    for (AcquistoDTO a : acquistoDTOList) {
                        System.out.println(a);
                        System.out.println("Ciao");
                    }
                } else {
                    System.out.println("Non ci sono acquisti nel db");
                }
                System.out.println();
            }
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Cosa vuoi fare?");
        if(UserSingleton.getInstance().getUsertype().equals("ADMIN")) {
            System.out.println("[L]eggi, [C]ancella, [G]estisci agenzia, [V]isualizza i tuoi acquisti, [I]ndietro, [E]sci");

            this.choice = getInput();
        }else{
            System.out.println("[V]isualizza i tuoi acquisti, [L]eggi acquisto, [T]orna alle case");
            this.choice = getInput();
        }
    }

    @Override
    public void submit() {
        if (UserSingleton.getInstance().getUsertype().equals("ADMIN")) {
            switch (choice.toUpperCase()) {
                case "L":
                    MainDispatcher.getInstance().callView(sub_package + "AcquistoRead", null);
                    break;
                case "A":
                    MainDispatcher.getInstance().callView(sub_package + "AcquistoInsert", null);
                    break;
                case "G":
                    MainDispatcher.getInstance().callView(sub_package + "AcquistoReadAgenzia", null);
                    break;
                case "V":
                    MainDispatcher.getInstance().callView(sub_package + "AcquistoReadUser", null);
                    break;
                case "I":
                    MainDispatcher.getInstance().callView("HomeAdmin", null);
                    break;
                case "E":
                    MainDispatcher.getInstance().callView("Login", null);
                    break;
                default:
                    System.out.println("\nNessuna scelta valida.");
                    Request request = new Request("Agenzia", "getAll", null);
                    MainDispatcher.getInstance().callAction(request);
            }
        }else{
            switch (choice.toUpperCase()){
                case "L":
                    MainDispatcher.getInstance().callView(sub_package + "AcquistoRead", null);
                    break;
                case "V":
                    MainDispatcher.getInstance().callView(sub_package + "AcquistoReadUser", null);
                    break;
                case "T":
                    MainDispatcher.getInstance().callView("Casa", null);
            }
        }
    }
}
