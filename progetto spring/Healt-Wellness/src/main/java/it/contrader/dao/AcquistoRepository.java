package it.contrader.dao;

import it.contrader.model.Acquisto;
import it.contrader.model.Agenzia;
import it.contrader.model.Casa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AcquistoRepository extends CrudRepository<Acquisto, Long> {

    public Acquisto findById(int id);

    public Acquisto findByCasaNomeLike(String nome);

    public List<Acquisto> findByCasaPrezzoGreaterThan(int prezzo);

    public List<Acquisto> findAllByAnagraficaId(Long id);

}
