package it.contrader.controller;

import it.contrader.dto.CasaDTO;
import it.contrader.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casa")
@CrossOrigin(origins = "http://localhost:4200")
public class CasaController {

    @Autowired
    private CasaService casaService;
    @GetMapping("/findbyid")
    public CasaDTO findById(@RequestParam Long id){
        return casaService.findById(id);
    }
    @PostMapping("/insert")
    public CasaDTO insert(@RequestBody CasaDTO casaDTO){
        return  casaService.save(casaDTO);
    }
    @PutMapping("/update")
    public CasaDTO update(@RequestBody CasaDTO casaDTO){ return  casaService.save(casaDTO);
    }
    @DeleteMapping("/deletebyid")
    public void deleteById(@RequestParam Long id){
        casaService.delete(id);
    }
    @GetMapping("/findall")
    public List<CasaDTO> findAll(){
        return casaService.findAll();
    }
    @GetMapping("/findfiltraprezzo")
    public List<CasaDTO> findFiltraPrezzo(@RequestParam Double prezzoMinimoFiltra){
        return casaService.findFiltraPrezzo(prezzoMinimoFiltra);
    }

    @GetMapping("/findfiltranome")
    public List<CasaDTO> findFiltraNome(@RequestParam String nome){
        return casaService.findFiltraNome(nome);
    }

    @GetMapping("/findfiltrametratura")
    public List<CasaDTO> findFiltraMetratura(@RequestParam int metraturaMinimaFiltra){
        return casaService.findFiltraMetratura(metraturaMinimaFiltra);
    }

    @GetMapping("/findfiltracostruita")
    public List<CasaDTO> findFiltraCostruita(@RequestParam int costruitaMinimoFiltra){
        return casaService.findFiltraCostruita(costruitaMinimoFiltra);
    }

    @GetMapping("/findallpaginata")
    public Page<CasaDTO> findAllPaginata(@RequestParam("pageNumber") int pageNumber , @RequestParam("pageSize") int pageSize){
        return casaService.findAllPaginata(PageRequest.of(pageNumber,pageSize));
    }

    @GetMapping("/findallbytipo")
    public List<CasaDTO> findAllByTipo(@RequestParam("tipo") String tipo){
        return casaService.findAllByTipo(tipo.toUpperCase());
    }

    @GetMapping("/filterall")
    public List<CasaDTO> filterAll(@RequestParam("nome") String nome,
                                   @RequestParam("prezzo") double prezzo,
                                   @RequestParam("metratura") int metratura,
                                   @RequestParam("data") int data){
        return casaService.filterAll(nome, prezzo, metratura, data);
    }
}
