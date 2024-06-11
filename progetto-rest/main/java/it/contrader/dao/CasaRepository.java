package it.contrader.dao;
import it.contrader.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CasaRepository extends JpaRepository<Casa, Long> {

    List<Casa> findByNomeContainingIgnoreCaseAndPrezzoLessThanEqualAndMetraturaGreaterThanEqualAndCostruitaGreaterThanEqual(
            String nome,
            Optional<Double> prezzo,
            Optional<Integer> metratura,
            Optional<Integer> costruita
    );

}
