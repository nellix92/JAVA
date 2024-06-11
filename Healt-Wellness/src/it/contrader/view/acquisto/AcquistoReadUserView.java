package it.contrader.view.acquisto;

import com.sun.tools.javac.Main;
import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.AcquistoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.view.AbstractView;

import java.io.FilterOutputStream;
import java.util.List;

public class AcquistoReadUserView extends AbstractView {

    private int id;

/*    @Override
    public void showResults(Response response) {
        if(response != null){
            List<AcquistoDTO> acquistoList = (List<AcquistoDTO>) response.getBody().get("acquisto");

            if (!acquistoList.isEmpty()) {
                for (AcquistoDTO a : acquistoList) {
                    System.out.println(a);
                }
            } else {
                System.out.println("Non ci sono acquisti nel db");
            }
        }
    }*/

    @Override
    public void showResults(Response response) {
        if (response != null && response.getBody() != null) {
            Object acquistoObject = response.getBody().get("acquisto");

            if (acquistoObject instanceof List) {
                List<AcquistoDTO> acquisto = (List<AcquistoDTO>) acquistoObject;

                if (!acquisto.isEmpty()) {
                    for (AcquistoDTO a : acquisto) {
                        System.out.println(a);
                    }
                } else {
                    System.out.println("La lista acquisto è vuota");
                }
            } else {
                System.out.println("La chiave 'acquisto' non è presente o non è una lista nell'oggetto Body della risposta.");
            }
        } else {
            System.out.println("La risposta è nulla o il corpo della risposta è nullo.");
        }
    }


    @Override
    public void showOptions() {
        System.out.println("Ecco i tuoi acquisti " + UserSingleton.getInstance().getUsername());
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.setController("Acquisto");
        request.setMethod("getByUser");
        MainDispatcher.getInstance().callAction(request);
        MainDispatcher.getInstance().callView("HomeUser", null);
    }
}
