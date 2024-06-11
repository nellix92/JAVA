package it.contrader.controller;

import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.AgenziaService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.LocalDate;

@Controller
@RequestMapping("/agenzia")
public class AgenziaController {

    @Autowired
    private AgenziaService service;

    @Autowired
    private UserService userService;
//--------------------------------------------------
    private void setAll(HttpServletRequest request) {
        request.getSession().setAttribute("list", service.getAll());
    }
//--------------------------------------------------
    @GetMapping("/getall")
    public String getAll(HttpServletRequest request)    {
        setAll(request);
        return "agenzia/agenziamanager";
    }
//--------------------------------------------------
    @GetMapping("/read")
    public String read(HttpServletRequest request
                    , @RequestParam("id") Long id){
        AgenziaDTO dto = service.read(id);
        request.getSession().setAttribute("dto", dto);
        return "agenzia/readagenzia";
    }
//--------------------------------------------------

    @GetMapping("/delete")
    public String delete(HttpServletRequest request
                        , @RequestParam("id") Long id){
        service.delete(id);
        setAll(request);
        return "agenzia/agenziamanager";
    }

//--------------------------------------------------
    @GetMapping("/update")
    public String update(HttpServletRequest request
                        , @RequestParam("id") Long id){
        request.getSession().setAttribute("dto", service.read(id));
        return "/agenzia/updateagenzia";
    }
    @PostMapping("/update")
    public String update(HttpServletRequest request
                        , @RequestParam("id") Long id
                        , @RequestParam("nome") String nome
                        , @RequestParam("descrizione") String descrizione
                        , @RequestParam("provincia") String provincia
                        , @RequestParam("citta") String citta
                        , @RequestParam("indirizzo") String indirizzo){

        AgenziaDTO dto = new AgenziaDTO();
        UserDTO u = (UserDTO) request.getSession().getAttribute("user");
        UserDTO userForAgenzia = userService.getByUsername(u.getUsername());
        dto.setId(id);
        dto.setNome(nome);
        dto.setDescrizione(descrizione);
        dto.setProvincia(provincia);
        dto.setIndirizzo(indirizzo);
        dto.setCitta(citta);
        dto.setAdmin_id(userForAgenzia.getId());

        service.update(dto);
        setAll(request);
        return "agenzia/agenziamanager";
    }
//--------------------------------------------------

    @PostMapping("/insert")
    public String insert(HttpServletRequest request
            , @RequestParam("nome") String nome
            , @RequestParam("descrizione") String descrizione
            , @RequestParam("provincia") String provincia
            , @RequestParam("citta") String citta
            , @RequestParam("indirizzo") String indirizzo) throws ParseException {

        AgenziaDTO dto = new AgenziaDTO();
        UserDTO u = (UserDTO) request.getSession().getAttribute("user");
        UserDTO userForAgenzia = userService.getByUsername(u.getUsername());

        dto.setNome(nome);
        dto.setDescrizione(descrizione);
        dto.setProvincia(provincia);
        dto.setIndirizzo(indirizzo);
        dto.setCitta(citta);
        dto.setAdmin_id(userForAgenzia.getId());

        service.insert(dto);
        AgenziaDTO newAgenzia = service.findByAdminId(dto.getAdmin_id());
        request.getSession().setAttribute("agenzia", newAgenzia);
        request.getSession().setAttribute("agenziaId", newAgenzia.getId());
        setAll(request);
        return "home";
    }
//--------------------------------------------------






}
