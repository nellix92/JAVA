package it.contrader.service;

import it.contrader.converter.AcquistoConverter;
import it.contrader.dao.AcquistoDAO;
import it.contrader.dto.AcquistoDTO;
import it.contrader.model.Acquisto;

import java.util.List;

public class AcquistoService extends AbstractService<Acquisto, AcquistoDTO>{

    private AcquistoDAO acquiDAO;

    public AcquistoService(){
        dao = new AcquistoDAO();
        this.acquiDAO = new AcquistoDAO();
        converter = new AcquistoConverter();
    }

    public List<AcquistoDTO> getByAnagrafica(int anagraficaId){ return converter.toDTOList(acquiDAO.getByAnagrafica(anagraficaId));}

    //public List<AcquistoDTO> getAllAgenzia(int agenziaID){ return converter.toDTOList(dao.getAllAgenzia(agenziaID));}
}
