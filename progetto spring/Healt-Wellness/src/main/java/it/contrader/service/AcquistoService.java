package it.contrader.service;

import it.contrader.converter.AcquistoConverter;
import it.contrader.dao.AcquistoRepository;
import it.contrader.dto.AcquistoDTO;
import it.contrader.model.Acquisto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquistoService extends AbstractService<Acquisto, AcquistoDTO>{

    @Autowired
    private AcquistoConverter converter;

    @Autowired
    private AcquistoRepository repository;

    public AcquistoDTO findById(Long id){
        return converter.toDTO(repository.findById(id).orElseThrow(()->new RuntimeException("id agenzia non trovato")));
    }

    public List<AcquistoDTO> findAllByAnagraficaId(Long id){
        return converter.toDTOList(repository.findAllByAnagraficaId(id));
    }

}
