package it.contrader.service;


import it.contrader.converter.AgenziaConverter;
import it.contrader.dao.AgenziaRepository;
import it.contrader.dto.AgenziaDTO;
import it.contrader.model.Agenzia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenziaService extends AbstractService<Agenzia, AgenziaDTO> {

    @Autowired
    private AgenziaConverter converter;
    @Autowired
    private AgenziaRepository repository;

    public AgenziaDTO findById(Long id){

        return converter.toDTO(repository.findById(id).orElseThrow(()->new RuntimeException("id agenzia non trovato")));
    }

    public AgenziaDTO findByAdminId(Long id){
        return converter.toDTO(repository.findByAdmin_id(id));
    }

}
