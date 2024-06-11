package it.contrader.dao;


import it.contrader.dto.AgenziaDTO;
import it.contrader.model.Agenzia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AgenziaRepository extends CrudRepository<Agenzia, Long> {
    List<Agenzia> findByNome(String nome);
    List<Agenzia> findByDescrizione(String descrizione);
    List<Agenzia> findByProvincia(String provincia);
    List<Agenzia> findByCitta(String citta);
    List<Agenzia> findByIndirizzo(String indirizzo);

    Agenzia findByAdmin_id(Long admin_id);

}