package it.contrader.service;

import it.contrader.converter.AcquistoConverter;
import it.contrader.dao.AcquistoDAO;
import it.contrader.dto.AcquistoDTO;

import java.util.List;

public class AcquistoService {

    private final AcquistoDAO acquistoDAO;

    private final AcquistoConverter acquistoConverter;

    public AcquistoService(){
        this.acquistoDAO = new AcquistoDAO();
        this.acquistoConverter = new AcquistoConverter();
    }

    public List<AcquistoDTO> getAll(){ return acquistoConverter.toDTOList(acquistoDAO.getAll()); }
    public boolean insert(AcquistoDTO dto){ return acquistoDAO.insert(acquistoConverter.toEntity(dto));}

    public List<AcquistoDTO> getByUser(int userId){ return acquistoConverter.toDTOList(acquistoDAO.getByUser(userId));}

    public List<AcquistoDTO> getAllAgenzia(int agenziaID){ return acquistoConverter.toDTOList(acquistoDAO.getAllAgenzia(agenziaID));}
    public AcquistoDTO read(int id){ return acquistoConverter.toDTO(acquistoDAO.read(id)); }
}
