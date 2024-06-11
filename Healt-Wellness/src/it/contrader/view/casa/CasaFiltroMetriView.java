package it.contrader.view.casa;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.CasaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.List;

public class CasaFiltroMetriView extends AbstractView {

    private int minMetri;

    private int maxMetri;

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
            System.out.println();
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci la metratura minima");
        minMetri = Integer.parseInt(getInput());
        System.out.println("Inserisci la metratura massima");
        maxMetri = Integer.parseInt(getInput());
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.getBody().put("minMetri", minMetri);
        request.getBody().put("maxMetri", maxMetri);
        request.setController("Casa");
        request.setMethod("filtraMetri");
        MainDispatcher.getInstance().callAction(request);
    }
}
