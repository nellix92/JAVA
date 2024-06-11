package it.contrader.service;

import it.contrader.converter.AgenziaConverter;
import it.contrader.dao.AgenziaDAO;
import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.UserDTO;

import java.util.List;

public class AgenziaService {

    private final AgenziaDAO agenziaDAO;

    private final AgenziaConverter agenziaConverter;

    public AgenziaService(){
        agenziaDAO = new AgenziaDAO();
        agenziaConverter = new AgenziaConverter();
    }

    public AgenziaDTO read(int id){
        return agenziaConverter.toDto(agenziaDAO.read(id));
    }

    public List<AgenziaDTO> getAll() {
        return agenziaConverter.toDTOList(agenziaDAO.getAll());
    }

    public boolean insert(AgenziaDTO dto){
        return agenziaDAO.insert(agenziaConverter.toEntity(dto));
    }

    public AgenziaDTO findByFk(int fk){
        return agenziaConverter.toDto(agenziaDAO.findByFk(fk));
    }

    public boolean update(AgenziaDTO dto){ return agenziaDAO.update(agenziaConverter.toEntity(dto)); }
    public boolean delete(int id){ return agenziaDAO.delete(id); }
}
