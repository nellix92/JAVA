package it.contrader.controller;
import it.contrader.dto.AcquistoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/acquisto")
@CrossOrigin(origins = "http://localhost:4200")
public class AcquistoController extends  AbstractController<AcquistoDTO>{
    @Autowired
    private AcquistoService acquistoService;

    @PostMapping("/createorder")
    public AcquistoDTO inserisci(@RequestBody AcquistoDTO a){
        return acquistoService.createOrder(a);
    }
    @GetMapping("/byuser")
    public List<AcquistoDTO> findByUser(@RequestParam Long id){
       return acquistoService.findByUserId(id);
    }
    
    @GetMapping("/bydataafter")
    public List<AcquistoDTO> findByDataAfter(@RequestParam String data){
        return acquistoService.findByDateAfter(LocalDate.parse(data));
    }
    @GetMapping("/bydatabefore")
    public List<AcquistoDTO> findByDataBefore(@RequestParam String data){
        return acquistoService.findByDateBefore(LocalDate.parse(data));
    }
    @GetMapping("/byprezzohigher")
    public List<AcquistoDTO> findByPrezzoGreater(@RequestParam double prezzo){
        return acquistoService.findByPrezzoGreater(prezzo);
    }
    @GetMapping("/byprezzolower")
    public List<AcquistoDTO> findByPrezzoLower(@RequestParam double prezzo) {
        return acquistoService.findByPrezzoLess(prezzo);
    }

    @GetMapping("/byuserid")
    public List<AcquistoDTO> findAllByAnagraficaId(@RequestParam("userId") Long userId){
        return acquistoService.findAllByUserId(userId);
    }

//    @GetMapping("/allpaged")
//    public Page<AcquistoDTO> findAllPaged(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
//        return acquistoService.findAllPaged(PageRequest.of(pageNumber, pageSize));
//    }
}
