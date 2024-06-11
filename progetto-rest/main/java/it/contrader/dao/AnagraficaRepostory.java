package it.contrader.dao;

import it.contrader.model.Anagrafica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AnagraficaRepostory extends JpaRepository<Anagrafica, Long> {

    Anagrafica findByUser_id(Long id);

}
