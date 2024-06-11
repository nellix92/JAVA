package it.contrader.controller;


import it.contrader.dao.CasaRepository;
import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.CasaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Casa;
import it.contrader.model.Casa.Tipo;
import it.contrader.service.AgenziaService;
import it.contrader.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/casa")
public class CasaController {

    @Autowired
    private CasaService service;

    @Autowired
    private AgenziaService agenziaService;
//--------------------------------------------------

    private void setAll(HttpServletRequest request){
//        System.out.println(service.getAll());
        request.getSession().setAttribute("list", service.getAll());}

//--------------------------------------------------

    @GetMapping("/getall")
    public String getAll(HttpServletRequest request)    {
        setAll(request);
        return "casa/casamanager";
    }

//--------------------------------------------------

    @GetMapping("/read")
    public String read(HttpServletRequest request
            , @RequestParam("id") Long id){
        request.getSession().setAttribute("dto", service.read(id));
        return "casa/readcasa";
    }

//--------------------------------------------------

    @GetMapping("/delete")
    public String delete(HttpServletRequest request
            , @RequestParam("id") Long id){
        service.delete(id);
        setAll(request);
        return "casa/casamanager";
    }

//--------------------------------------------------

    @GetMapping("/preupdate")
    public String update(HttpServletRequest request
            , @RequestParam("id") Long id){
        request.getSession().setAttribute("dto", service.read(id));
        return "casa/updatecasa";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request
            , @RequestParam Long id
            , @RequestParam String nome
            , @RequestParam double prezzo
            , @RequestParam String indirizzo
            , @RequestParam int metratura
            , @RequestParam int costruita
            , @RequestParam String dettagli
            , @RequestParam String tipo
            , @RequestParam(name = "disponibile", required = false) boolean disponibile
    ){

        CasaDTO dto = new CasaDTO();
        CasaDTO oldCasa = service.findById(id);

        dto.setId(id);
        dto.setNome(nome);
        dto.setPrezzo(prezzo);
        dto.setIndirizzo(indirizzo);
        dto.setMetratura(metratura);
        dto.setCostruita(costruita);
        dto.setDettagli(dettagli);
        dto.setTipo(Tipo.valueOf(tipo.toUpperCase()));
        dto.setDisponibile(disponibile);
        dto.setAgenzia_id(oldCasa.getAgenzia_id());

        service.update(dto);
        setAll(request);
        return "casa/casamanager";
    }

//--------------------------------------------------

    @PostMapping("/insert")
    public String insert(HttpServletRequest request
            , @RequestParam String nome
            , @RequestParam double prezzo
            , @RequestParam String indirizzo
            , @RequestParam int metratura
            , @RequestParam int costruita
            , @RequestParam String dettagli
            , @RequestParam String tipo){

        CasaDTO dto = new CasaDTO();
        UserDTO u = (UserDTO) request.getSession().getAttribute("user");
        AgenziaDTO agenziaForCasa = agenziaService.findByAdminId(u.getId());

        dto.setNome(nome);
        dto.setPrezzo(prezzo);
        dto.setIndirizzo(indirizzo);
        dto.setMetratura(metratura);
        dto.setCostruita(costruita);
        dto.setDettagli(dettagli);
        dto.setTipo(Tipo.valueOf(tipo.toUpperCase()));
        dto.setDisponibile(true);
        dto.setAgenzia_id(agenziaForCasa.getId());
        System.out.println(dto);

        service.insert(dto);
        setAll(request);
        return "casa/casamanager";
    }


    @Autowired
    private CasaRepository casaRepository;

    @GetMapping("/search")
    public String search(HttpServletRequest request,
                        @RequestParam(value = "nome", required = false) String nome,
                        @RequestParam(value = "prezzo", required = false) String prezzo,
                        @RequestParam(value = "metratura", required = false) String metratura,
                        @RequestParam(value = "costruita", required = false) String costruita
                         ){

        double newPrezzo;
        int newMetratura;
        int newCostruita;

        try {
            if (prezzo.isEmpty()) {
                newPrezzo = 10000000000000000000000000000000000000000000000000000000000000000000000.0;
            } else {
                newPrezzo = Double.parseDouble(prezzo);
            }
            if (metratura.isEmpty()) {
                newMetratura = 0;
            } else {
                newMetratura = Integer.parseInt(metratura);
            }
            if (costruita.isEmpty()) {
                newCostruita = 0;
            } else {
                newCostruita = Integer.parseInt(costruita);
            }
        }catch (NumberFormatException e) {
            String errorMessage = "Inserire un valore numerico valido per la metratura, il prezzo o l'anno.";
            request.setAttribute("errorMessage", errorMessage);
            return "/casa/casamanager";
        }

        List<CasaDTO> result = service.megaFilter(nome, newPrezzo, newMetratura, newCostruita);

//        System.out.println("result del megafiltro" + result);
//        System.out.println("nome " + nome);
//        System.out.println("prezzo " + prezzo + " newPrezzo " + newPrezzo);
//        System.out.println("metratura " + metratura + " newMetratura " + newMetratura);
//        System.out.println("costruita " + costruita + " newCostruita " + newCostruita);
        request.getSession().setAttribute("list", result);

        return "casa/casamanager";
    }

}
