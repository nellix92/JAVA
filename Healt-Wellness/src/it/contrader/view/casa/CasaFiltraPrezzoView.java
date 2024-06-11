package it.contrader.view.casa;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.CasaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.util.List;

public class CasaFiltraPrezzoView extends AbstractView {

    private Double minPrezzo;
    private Double maxPrezzo;

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
        System.out.println("Scegli il prezzo MINIMO");
        minPrezzo = Double.parseDouble(String.valueOf(getInput()));
        System.out.println("Scegli il prezzo MASSIMO");
        maxPrezzo = Double.parseDouble(String.valueOf(getInput()));
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.getBody().put("minPrezzo", minPrezzo);
        request.getBody().put("maxPrezzo", maxPrezzo);
        request.setController("Casa");
        request.setMethod("filtraPrezzo");
        MainDispatcher.getInstance().callAction(request);
    }
}
