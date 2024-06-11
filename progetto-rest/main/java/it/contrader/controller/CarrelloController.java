package it.contrader.controller;
import it.contrader.converter.CarrelloConverter;
import it.contrader.dto.CarrelloDTO;
import it.contrader.service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrello")
@CrossOrigin(origins = "http://localhost:4200")
public class CarrelloController extends AbstractController<CarrelloDTO>{
    @Autowired
    private CarrelloService carrelloService;
    @Autowired
    private CarrelloConverter carrelloConverter;
}
