package it.contrader.view.casa;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.CasaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.List;

public class CasaFiltroTipoView extends AbstractView {

    private String tipo;
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
        System.out.println("Inserisci il tipo di casa che stai cercando");
        tipo = getInput();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.getBody().put("tipo", tipo);
        request.setController("Casa");
        request.setMethod("filtraTipo");
        MainDispatcher.getInstance().callAction(request);
    }
}
