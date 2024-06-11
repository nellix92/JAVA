package it.contrader.dao;
import it.contrader.model.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
}
