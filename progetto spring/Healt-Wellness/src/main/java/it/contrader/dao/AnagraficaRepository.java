package it.contrader.dao;


import it.contrader.model.Anagrafica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface AnagraficaRepository   extends CrudRepository<Anagrafica, Long> {

    public Anagrafica findById(long id);

    public  Anagrafica findByEmail(String email);

    public  Anagrafica findByNomeAndCognome(String nome, String cognome);

    public Optional<Anagrafica> findByUser_id(Long id);
}


