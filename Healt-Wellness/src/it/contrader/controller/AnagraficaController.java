package it.contrader.controller;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.AnagraficaService;

public class AnagraficaController implements Controller{

    private static String sub_package = "anagrafica.";

    private final AnagraficaService anagraficaService;

    public AnagraficaController() {
        anagraficaService = new AnagraficaService();
    }
    @Override
    public void doControl(Request request) {

        if (request != null) {

            Response response = new Response();
            switch (request.getMethod().toUpperCase()) {
                case "REGISTERANAGRAFICA":
                    AnagraficaDTO anagraficatoinsert = (AnagraficaDTO) request.getBody().get("anagraficaToInsert");
                    anagraficaService.insert(anagraficatoinsert);
                    break;
                case "UPDATE":
                    AnagraficaDTO anagraficaToUpdate = (AnagraficaDTO) request.getBody().get("anagraficaToUpdate");
                    anagraficaService.update(anagraficaToUpdate);
                    MainDispatcher.getInstance().callView(sub_package + "AnagraficaUpdate", response);
                case "READ":
                    AnagraficaDTO anagraficaDTO = anagraficaService.read(Integer.parseInt(request.getBody().get("idUser").toString()));
                    response.put("anagrafica", anagraficaDTO);
                    MainDispatcher.getInstance().callView(sub_package + "AnagraficaRead", response);
                    break;
                default:
                    System.out.println("No method matches the inserted method: " + request.getMethod());
                    MainDispatcher.getInstance().callView("Login", null);
                    break;
            }
        }

    }
}
