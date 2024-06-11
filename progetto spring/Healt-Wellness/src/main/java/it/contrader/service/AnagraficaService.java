package it.contrader.service;

import it.contrader.converter.AnagraficaConverter;
import it.contrader.dao.AnagraficaRepository;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaService  extends  AbstractService<Anagrafica, AnagraficaDTO>{

    @Autowired
    private AnagraficaConverter converter;

    @Autowired
    private AnagraficaRepository repository;

    public AnagraficaDTO findById(Long id){
        return  converter.toDTO(repository.findById(id).orElseThrow(()->new RuntimeException("id anagrafica non trovato")));
    }

    public AnagraficaDTO findByEmail(String email){
        return  converter.toDTO(repository.findByEmail(email));
    }

    public AnagraficaDTO findByNomeAndCognome(String nome, String cognome){
        return  converter.toDTO(repository.findByNomeAndCognome(nome,cognome));
    }

    public AnagraficaDTO findByUserId(Long id){
        return converter.toDTO(repository.findByUser_id(id).orElseThrow(()-> new RuntimeException("ID UTENTE NON TROVATO")));
    }
}
