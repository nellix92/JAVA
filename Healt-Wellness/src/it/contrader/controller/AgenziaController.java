package it.contrader.controller;

import it.contrader.dto.AgenziaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.AgenziaService;

import java.util.List;

public class AgenziaController implements Controller{

    private final AgenziaService agenziaService;

    private static String sub_package = "agenzia.";

    public AgenziaController(){ agenziaService = new AgenziaService();}


    @Override
    public void doControl(Request request) {
        if(request != null){

            Response response = new Response();

            switch(request.getMethod().toUpperCase()){
                case "GETALL":
                    List<AgenziaDTO> agenziaDTOList = agenziaService.getAll();
                    response.put("agenzia", agenziaDTOList);
                    MainDispatcher.getInstance().callView("Agenzia", response);
                    break;
                case "READ":
                    AgenziaDTO agenziaDTO = agenziaService.read(Integer.parseInt(request.getBody().get("id").toString()));
                    response.put("agenzia", agenziaDTO);
                    MainDispatcher.getInstance().callView(sub_package + "AgenziaRead", response);
                    break;
                case "INSERT":
                    AgenziaDTO agenziaToInsert = (AgenziaDTO) request.getBody().get("agenziaToInsert");
                    agenziaService.insert(agenziaToInsert);
                    MainDispatcher.getInstance().callView(sub_package + "AgenziaInsert", response);
                    break;
                case "DELETE":
                    agenziaService.delete(Integer.parseInt(request.getBody().get("id").toString()));
                    MainDispatcher.getInstance().callView(sub_package + "AgenziaDelete", response);
                    break;
                case "UPDATE":
                    AgenziaDTO agenziaToUpdate = (AgenziaDTO) request.getBody().get("agenziaToUpdate");
                    agenziaService.update(agenziaToUpdate);
                    MainDispatcher.getInstance().callView(sub_package + "AgenziaUpdate", response);
                    break;
                default:
                    System.out.println("\n 404 pagina non trovata");
                    MainDispatcher.getInstance().callView("HomeAdmin", null);
            }
        }
    }
}
