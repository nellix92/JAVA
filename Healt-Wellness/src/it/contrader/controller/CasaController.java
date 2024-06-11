package it.contrader.controller;

import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.CasaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CasaService;

import java.util.List;
import java.util.Scanner;

public class CasaController implements Controller{

    private final CasaService casaService;

    private static String sub_package = "casa.";

    public CasaController(){ casaService = new CasaService(); }

    @Override
    public void doControl(Request request) {
        if(request != null){
            Response response = new Response();

            switch(request.getMethod().toUpperCase()){
                case "GETALL":
                    List<CasaDTO> casaDTOList = casaService.getAll();
                    response.put("casa", casaDTOList);
                    MainDispatcher.getInstance().callView("Casa", response);
                    break;
                case "READ":
                    CasaDTO casaDTO = casaService.read(Integer.parseInt(request.getBody().get("id").toString()));
                    response.put("casa", casaDTO);
                    MainDispatcher.getInstance().callView(sub_package + "CasaRead", response);
                    break;
                case "FILTRATIPO":
                    String tipo = (String) request.getBody().get("tipo");
                    List<CasaDTO> casaFiltroTipo = casaService.getFiltroTipo(tipo);
                    response.put("casa", casaFiltroTipo);
                    MainDispatcher.getInstance().callView(sub_package + "CasaFiltroTipo", response);
                    break;
                case "FILTRAPREZZO":
                    Double minPrezzo = (Double) request.getBody().get("minPrezzo");
                    Double maxPrezzo = (Double) request.getBody().get("maxPrezzo");
                    List<CasaDTO> casaFiltrataPrezzo = casaService.getFilterPrezzo(minPrezzo, maxPrezzo);
                    response.put("casa", casaFiltrataPrezzo);
                    MainDispatcher.getInstance().callView(sub_package + "CasaFiltraPrezzo", response);
                    break;
                case "FILTRAMETRI":
                    int minMetri = (int) request.getBody().get("minMetri");
                    int maxMetri = (int) request.getBody().get("maxMetri");
                    List<CasaDTO> casaFiltrataMetri = casaService.getFiltroMetri(minMetri, maxMetri);
                    response.put("casa", casaFiltrataMetri);
                    MainDispatcher.getInstance().callView(sub_package + "CasaFiltroMetri", response);
                    break;
                case "FILTRANOME":
                    String nome = (String) request.getBody().get("nome");
                    List<CasaDTO> casaFiltroNome = casaService.getFiltroNome(nome);
                    response.put("casa", casaFiltroNome);
                    MainDispatcher.getInstance().callView(sub_package + "CasaFiltraNome", response);
                    break;
                case "INSERT":
                    CasaDTO casaToInsert = (CasaDTO) request.getBody().get("casaToInsert");
                    casaService.insert(casaToInsert);
                    MainDispatcher.getInstance().callView(sub_package + "CasaInsert", response);
                    break;
                case "UPDATE":
                    CasaDTO casaToUpdate = (CasaDTO) request.getBody().get("casaToUpdate");
                    casaService.update(casaToUpdate);
                    MainDispatcher.getInstance().callView(sub_package + "CasaUpdate", response);
                    break;
                case "DELETE":
                    casaService.delete(Integer.parseInt(request.getBody().get("id").toString()));
                    MainDispatcher.getInstance().callView(sub_package + "CasaDelete", response);
                    break;
                default:
                    System.out.println("\n 404 pagina non trovata");
                    MainDispatcher.getInstance().callView("HomeAdmin", null);
            }
        }
    }
}
