package it.contrader.service;
import it.contrader.converter.CarrelloConverter;
import it.contrader.dao.CarrelloRepository;
import it.contrader.dto.CarrelloDTO;
import it.contrader.model.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService extends AbstractService<Carrello, CarrelloDTO>{
    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private CarrelloConverter carrelloConverter;

}
