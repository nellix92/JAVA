package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AgenziaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;

import java.util.List;

public class AgenziaView extends AbstractView{

    private static String sub_package = "agenzia.";
    private String choice;
    @Override
    public void showResults(Response response) {
        if(response != null){
            System.out.println("\n ------------------ Elenco Agenzie ------------------ \n");
            System.out.println("Dettagli Agenzie");

            List<AgenziaDTO> agenziaDTOList = (List<AgenziaDTO>) response.getBody().get("agenzia");
            if(agenziaDTOList != null){
                for(AgenziaDTO a : agenziaDTOList){
                    System.out.println(a);
                }
            }else{
                System.out.println("Non ci sono agenzie nel db");
            }
            System.out.println();
        }
    }

    @Override
    public void showOptions() {
        if(UserSingleton.getInstance().getUsertype().equals("ADMIN")) {
            System.out.println("Cosa vuoi fare?");
            System.out.println("[L]eggi, [A]ggiungi, [M]odifica, [C]ancella, [I]ndietro, [E]sci");


            this.choice = getInput();
        }else if (UserSingleton.getInstance().getUsertype() == null){
            System.out.println("Cosa vuoi fare?");
            System.out.println("[L]eggi, [I]ndietro, [E]sci");

            this.choice = getInput();
        }else{
            System.out.println("Cosa vuoi fare?");
            System.out.println("[L]eggi, [I]ndietro, [E]sci");

            this.choice = getInput();
        }
    }

    @Override
    public void submit() {
        switch(choice.toUpperCase()){
            case "L":
                MainDispatcher.getInstance().callView(sub_package + "AgenziaRead", null);
                break;
            case "A":
                MainDispatcher.getInstance().callView(sub_package + "AgenziaInsert", null);
                break;
            case "M":
                MainDispatcher.getInstance().callView(sub_package + "AgenziaUpdate", null);
                break;
            case "C":
                MainDispatcher.getInstance().callView(sub_package + "AgenziaDelete", null);
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
    }
}
