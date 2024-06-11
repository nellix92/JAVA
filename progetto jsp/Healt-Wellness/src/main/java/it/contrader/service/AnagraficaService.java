package it.contrader.service;

import it.contrader.converter.AnagraficaConverter;
import it.contrader.dao.AnagraficaDAO;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;

import java.util.List;

/**
 *
 * @author Vittorio
 *
 *Grazie all'ereditariet� mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class AnagraficaService extends AbstractService<Anagrafica, AnagraficaDTO> {

    private AnagraficaConverter anagraficaConverter;

    private AnagraficaDAO anagraficaDAO;

    //Istanzio DAO  e Converter specifici.
    public AnagraficaService(){
        this.anagraficaDAO = new AnagraficaDAO();
        this.anagraficaConverter = new AnagraficaConverter();
    }

    public List<AnagraficaDTO> getAll(){ return anagraficaConverter.toDTOList(anagraficaDAO.getAll()); }

    public AnagraficaDTO read(int id) {
        return anagraficaConverter.toDTO(anagraficaDAO.read(id));
    }


    public boolean insert(AnagraficaDTO dto) {
        return anagraficaDAO.insert(anagraficaConverter.toEntity(dto));
    }

    public boolean update(AnagraficaDTO dto) {
        return anagraficaDAO.update(anagraficaConverter.toEntity(dto));
    }

    public AnagraficaDTO findByUser(int id){
        return anagraficaConverter.toDTO(anagraficaDAO.readByUser(id));
    }

}
