package it.contrader.controller;


import it.contrader.dto.AgenziaDTO;
import it.contrader.service.AgenziaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenzia")
@CrossOrigin(origins = "http://localhost:4200")
public class AgenziaController extends AbstractController<AgenziaDTO>{

    @Autowired
    private AgenziaService agenziaService;
//-------------------------------------------------
    @GetMapping("/findall")
    public List<AgenziaDTO> findAll() {
        return  agenziaService.getAll();
    }
//-------------------------------------------------
    @GetMapping("/findbyid")
    public AgenziaDTO findById(@RequestParam Long id) {
        return agenziaService.findById(id);
    }
//-------------------------------------------------
    @PostMapping("/insert")
    public AgenziaDTO insert(@RequestBody AgenziaDTO agenziaDTO) {
        return agenziaService.insert(agenziaDTO);
    }
//-------------------------------------------------
    @PutMapping("/update")
    public AgenziaDTO update(@RequestBody AgenziaDTO agenziaDTO) {
        return agenziaService.update(agenziaDTO);
    }
//-------------------------------------------------
    @DeleteMapping("/deletebyid")
    public void deleteById(@RequestParam Long id) {
        agenziaService.delete(id);
    }
//-------------------------------------------------
    @GetMapping("/findallpaginata")
    public Page<AgenziaDTO> findAllPaginata(
                        @RequestParam("pageSize") int pageNumber,
                        @RequestParam("pageNumber") int pageSize ) {
        return agenziaService.findAllPaginata(PageRequest.of(pageSize, pageNumber));
    }
//-------------------------------------------------

    @GetMapping("/findbyuserid")
    public AgenziaDTO findByUserId(@RequestParam ("id") Long id){
        return agenziaService.findByUserId(id);
    }
//-------------------------------------------------


}
