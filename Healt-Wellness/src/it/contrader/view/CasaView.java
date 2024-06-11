package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.CasaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;

import java.util.List;

public class CasaView extends AbstractView{

    private static String sub_package = "casa.";

    private String choice;


    @Override
    public void showResults(Response response) {
        if(response != null){
            System.out.println("\n ------------------ Elenco Case ------------------ \n");
            System.out.println("Dettagli Case");

            List<CasaDTO> casaDTOList = (List<CasaDTO>) response.getBody().get("casa");
            if(casaDTOList != null){
                for(CasaDTO c : casaDTOList){
                    System.out.println(c);
                }
            }else{
                System.out.println("Non ci sono Case nel db");
            }
            System.out.println();
        }
    }

    @Override
    public void showOptions() {
        if(UserSingleton.getInstance().getUsertype().equals("ADMIN")) {
            System.out.println("Cosa vuoi fare?");
            System.out.println("[L]eggi, [A]ggiungi, [Co]mpra, [M]odifica, [C]ancella, [I]ndietro, [F]iltra, [E]sci");

            this.choice = getInput();
        }else{
            System.out.println("Cosa vuoi fare?");
            System.out.println("[L]eggi, [Co]mpra, [I]ndietro, [F]iltra, [E]sci");

            this.choice = getInput();
        }
    }

    @Override
    public void submit() {
        switch(choice.toUpperCase()){
            case "L":
                MainDispatcher.getInstance().callView(sub_package + "CasaRead", null);
                break;
            case "A":
                MainDispatcher.getInstance().callView(sub_package + "CasaInsert", null);
                break;
            case "M":
                MainDispatcher.getInstance().callView(sub_package + "CasaUpdate", null);
                break;
            case "C":
                MainDispatcher.getInstance().callView(sub_package + "CasaDelete", null);
                break;
            case "CO":
                MainDispatcher.getInstance().callView("acquisto.AcquistoInsert", null);
            case "I":
                if (UserSingleton.getInstance().getUsertype().equals("ADMIN")) {
                    MainDispatcher.getInstance().callView("HomeAdmin", null);
                }else{
                    MainDispatcher.getInstance().callView("HomeUser", null);

                }
                break;
            case "F":
                MainDispatcher.getInstance().callView(sub_package + "CasaFiltra", null);
                break;
            case "E":
                MainDispatcher.getInstance().callView("Login", null);
                break;
            default:
                System.out.println("\nNessuna scelta valida.");
                Request request = new Request("Casa", "getAll", null);
                MainDispatcher.getInstance().callAction(request);
        }
    }
}
