package it.contrader.dao;

import it.contrader.model.Casa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CasaRepository extends CrudRepository<Casa, Long> {

    Casa findById(int id);
    List<Casa> findByNome(String nome);
    List<Casa> findByPrezzo(double prezzo);
    List<Casa> findByIndirizzo(String indirizzo);
    List<Casa> findByMetratura(int metratura);
    List<Casa> findByCostruita(int costruita);
    List<Casa> findByDettagli(String dettagli);
    List<Casa> findByTipo(String tipo);

    List<Casa> findAllByAgenziaId(Long id);

    List<Casa> findByNomeLikeAndPrezzoLessThanAndMetraturaGreaterThanAndCostruitaGreaterThan(String nome, double prezzo, int metratura, int costruita);

    List<Casa> findByNomeContainingIgnoreCaseAndPrezzoLessThanEqualAndMetraturaGreaterThanEqualAndCostruitaGreaterThanEqual(
            String nome,
            Optional<Double> prezzo,
            Optional<Integer> metratura,
            Optional<Integer> costruita
    );
}
