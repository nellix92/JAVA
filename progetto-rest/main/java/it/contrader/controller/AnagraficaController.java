package it.contrader.controller;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anagrafica")
@CrossOrigin(origins = "http://localhost:4200")
public class AnagraficaController extends AbstractController<AnagraficaDTO>{
    @Autowired
    private AnagraficaService anagraficaService;

    @GetMapping("/getbyuserid")
    public ResponseEntity<AnagraficaDTO> findByUserId(@RequestParam Long id){
        return new ResponseEntity<>(anagraficaService.findByUserId(id), HttpStatus.OK);
    }
    //funziona su postman
//    @GetMapping("/findbyid")
//    public AnagraficaDTO findById(@RequestParam Long id) {return anagraficaService.read(id);}
//
//    //funziona su postman
//    @PostMapping("/insert")
//    public AnagraficaDTO insert(@RequestBody AnagraficaDTO anagraficaDTO){ return anagraficaService.insert(anagraficaDTO); }
//
//    //funziona su postman
//    @PutMapping("/update")
//    public AnagraficaDTO update(@RequestBody AnagraficaDTO anagraficaDTO){ return anagraficaService.insert(anagraficaDTO); }
//
//    //funziona su postman
//    @DeleteMapping("/deletebyid")
//    public void deleteById(@RequestParam Long id) { anagraficaService.delete(id); }
//
//    //funziona su postman
//    @GetMapping("/findall")
//    public List<AnagraficaDTO> findAll(){ return anagraficaService.getAll(); }

}
