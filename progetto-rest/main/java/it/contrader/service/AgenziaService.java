package it.contrader.service;

import it.contrader.converter.AgenziaConverter;
import it.contrader.dao.AgenziaRepository;
import it.contrader.dto.AgenziaDTO;
import it.contrader.model.Agenzia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgenziaService extends AbstractService<Agenzia, AgenziaDTO>{

    @Autowired
    AgenziaRepository agenziaRepository;
    @Autowired
    AgenziaConverter agenziaConverter;

    public AgenziaDTO findById (Long id){
        return agenziaConverter.toDTO(agenziaRepository.findById(id).orElseThrow(()->new RuntimeException("Id agenzia non trovato")));
    }

    public AgenziaDTO findByUserId(Long id){
        return agenziaConverter.toDTO(agenziaRepository.findByAdminId(id));
    }

    public Page<AgenziaDTO> findAllPaginata(Pageable pageable) {
        return agenziaConverter.toDTOPage(agenziaRepository.findAll(pageable));
    }
}
