package it.contrader.view.casa;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.CasaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.List;

public class CasaFiltraNomeView extends AbstractView {

    private String nome;

    @Override
    public void showResults(Response response) {
        if(response != null){
            System.out.println("\n ------------------ Elenco Case Filtrate ------------------ \n");

            List<CasaDTO> casaDTOList = (List<CasaDTO>) response.getBody().get("casa");
            if(casaDTOList != null){
                for(CasaDTO c : casaDTOList){
                    System.out.println(c);
                }
                System.out.println();
                MainDispatcher.getInstance().callView("Casa", null);
                System.out.println();
            }else{
                System.out.println("Non ci sono Case che corrispondono alla ricerca");
            }
            MainDispatcher.getInstance().callView("Casa", null);
            System.out.println();
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci il nome della casa che cerchi");
        nome = getInput();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.getBody().put("nome", nome);
        request.setController("Casa");
        request.setMethod("filtraNome");
        MainDispatcher.getInstance().callAction(request);
    }
}
