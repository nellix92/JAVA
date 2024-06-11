package it.contrader.service;

import it.contrader.converter.CasaConverter;
import it.contrader.dao.CasaRepository;
import it.contrader.dto.CasaDTO;
import it.contrader.model.Casa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService extends AbstractService<Casa, CasaDTO>{
    @Autowired
    private CasaConverter converter;

    @Autowired
    private CasaRepository repository;

    public CasaDTO findById(Long id){
        return converter.toDTO(repository.findById(id).orElseThrow(()->new RuntimeException("id agenzia non trovato")));
    }

    public List<CasaDTO> findByAgenziaId(Long id){
        return converter.toDTOList(repository.findAllByAgenziaId(id));
    }

    public List<CasaDTO> findByNomeLikeAndPrezzoLessThanAndMetraturaGreaterThanAndCostruitaGreaterThan(String nome, double prezzo, int metratura, int costruita){
        return converter.toDTOList(repository.findByNomeLikeAndPrezzoLessThanAndMetraturaGreaterThanAndCostruitaGreaterThan(nome, prezzo, metratura, costruita));
    }

    public List<CasaDTO> megaFilter(String nome, Double price, Integer metratura, Integer costruita){
        return converter.toDTOList(repository.findByNomeContainingIgnoreCaseAndPrezzoLessThanEqualAndMetraturaGreaterThanEqualAndCostruitaGreaterThanEqual(nome, Optional.ofNullable(price), Optional.ofNullable(metratura), Optional.ofNullable(costruita)));
    }
}
