package it.contrader.controller;

import it.contrader.dto.AcquistoDTO;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.CasaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.AcquistoService;
import it.contrader.service.AgenziaService;
import it.contrader.service.AnagraficaService;
import it.contrader.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
@RequestMapping("/acquisto")
public class AcquistoController {
    @Autowired
    private AcquistoService acquistoService;

    @Autowired
    private CasaService casaService;

    @Autowired
    private AnagraficaService anagraficaService;

    @Autowired
    private AgenziaService agenziaService;

    @GetMapping("getall")
    public String getAll(HttpServletRequest request){
        setAll(request);
        return "acquisto/acquistomanager";
    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request,
                         @RequestParam("houseId")Long casaId) {

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        AnagraficaDTO anagraficaDTO = anagraficaService.findByUserId(userDTO.getId());
        CasaDTO casaDTO = casaService.findById(casaId);

        AcquistoDTO acquistoDTO = new AcquistoDTO();

        acquistoDTO.setData(LocalDate.now());
        acquistoDTO.setPrezzo(casaDTO.getPrezzo());
        acquistoDTO.setCasa_id(casaDTO.getId());
        acquistoDTO.setAnagrafica_id(anagraficaDTO.getId());

        casaDTO.setDisponibile(false);
        acquistoService.insert(acquistoDTO);
        casaService.update(casaDTO);
        setAll(request);
        return "acquisto/acquistomanager";
    }

    @GetMapping("/read")
    public String read(HttpServletRequest request, @RequestParam("id") Long id) {
        request.getSession().setAttribute("acquistoDTO", acquistoService.read(id));
        return "acquisto/readacquistouser";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
        AcquistoDTO acquistoDTO = acquistoService.findById(id);
        CasaDTO casaDTO = casaService.findById(acquistoDTO.getCasa_id());
        casaDTO.setDisponibile(true);
        casaService.update(casaDTO);
        acquistoService.delete(id);
        setAll(request);
        return "acquisto/acquistomanager";
    }

    private void setAll(HttpServletRequest request) {
        request.getSession().setAttribute("list", acquistoService.getAll());
        request.getSession().setAttribute("casaList", casaService.getAll());
        request.getSession().setAttribute("anagraficaList", anagraficaService.getAll());
        request.getSession().setAttribute("agenziaList", agenziaService.getAll());
        request.getSession().setAttribute("listaAcquisti", acquistoService.findAllByAnagraficaId((Long) request.getSession().getAttribute("anagraficaId")));
        request.getSession().setAttribute("listaVendite", casaService.findByAgenziaId((Long) request.getSession().getAttribute("agenziaId")));
    }

}
