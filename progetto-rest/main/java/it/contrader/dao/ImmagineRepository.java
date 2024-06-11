package it.contrader.dao;

import it.contrader.model.Immagine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImmagineRepository extends JpaRepository<Immagine, Long> {

    Immagine findByUserId(int id);

    List<Immagine> findByCasaId(int id);

}
