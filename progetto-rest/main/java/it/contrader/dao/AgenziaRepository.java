package it.contrader.dao;


import it.contrader.model.Agenzia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface AgenziaRepository extends JpaRepository<Agenzia, Long> {

     Agenzia findByNomeAndIndirizzo (String nome, String indirizzo);
     Agenzia findByAdminEmail(String username);

     Agenzia findByAdminId(Long id);

}
