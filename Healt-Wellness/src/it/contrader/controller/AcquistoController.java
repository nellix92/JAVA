package it.contrader.controller;

import it.contrader.dto.AcquistoDTO;
import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.CasaDTO;
import it.contrader.main.AgenziaSingleton;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.service.AcquistoService;
import it.contrader.service.CasaService;

import java.util.List;


public class AcquistoController  implements Controller {

    private final AcquistoService acquistoService;

    private final CasaService casaService;

    private static String sub_package = "acquisto.";

    public AcquistoController(){
        casaService = new CasaService();
        acquistoService = new AcquistoService();
    }

    @Override
    public void doControl(Request request) {
        Response response = new Response();

        switch (request.getMethod().toUpperCase()){
            case "GETALL":
                List<AcquistoDTO> acquistoDTOList = acquistoService.getAll();
                response.put("acquisto", acquistoDTOList);
                MainDispatcher.getInstance().callView("Acquisto", response);
                break;
            case "GETBYAGENZIA":
                List<AcquistoDTO> acquistoByAgenziaList = acquistoService.getAllAgenzia(Integer.parseInt(request.getBody().get("id").toString()));
                response.put("acquisto", acquistoByAgenziaList);
                MainDispatcher.getInstance().callView(sub_package + "AcquistoReadAgenzia", response);
                break;
            case "GETBYUSER":
                List<AcquistoDTO> acquistoByUser = acquistoService.getByUser(UserSingleton.getInstance().getId());

                for(AcquistoDTO a : acquistoByUser){
                    System.out.println(a);
                }

                response.put("acquisto", acquistoByUser);
                MainDispatcher.getInstance().callView("Acquisto", response);
                break;
            case "READ":
                AcquistoDTO acquistoDTO = acquistoService.read(Integer.parseInt(request.getBody().get("id").toString()));
                response.put("acquisto", acquistoDTO);
                MainDispatcher.getInstance().callView(sub_package + "AcquistoRead", response);
                break;
            case "INSERT":
                CasaDTO casaDTO = casaService.getNome(request.getBody().get("nome").toString());
                AcquistoDTO acquistoToInsert = new AcquistoDTO(UserSingleton.getInstance().getId(), casaDTO.getNome(), casaDTO.getPrezzo(), casaDTO.getAgenzia_id());
                System.out.println(acquistoToInsert);
                acquistoService.insert(acquistoToInsert);
                casaService.delete(casaDTO.getId());
                MainDispatcher.getInstance().callView(sub_package + "AcquistoInsert", response);
                break;
            default:
                if(UserSingleton.getInstance().getUsertype().equals("ADMIN")){
                System.out.println("\n 404 pagina non trovata");
                MainDispatcher.getInstance().callView("HomeAdmin", null);
                }else{
                    System.out.println("\n 404 pagina non trovata");
                    MainDispatcher.getInstance().callView("HomeUser", null);
                }

        }
    }
}
