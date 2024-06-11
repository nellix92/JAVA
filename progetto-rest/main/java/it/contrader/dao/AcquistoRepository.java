package it.contrader.dao;
import it.contrader.model.Acquisto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AcquistoRepository extends JpaRepository<Acquisto, Long> {
    Optional<Acquisto> findById(Long id);
    List<Acquisto> findAll();

    List<Acquisto> findAllByAnagraficaUserId(Long idUser);
}
