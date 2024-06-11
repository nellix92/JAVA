package it.contrader.service;


import it.contrader.converter.AgenziaConverter;
import it.contrader.dao.AgenziaDAO;
import it.contrader.dto.AgenziaDTO;
import it.contrader.model.Agenzia;

import java.util.List;

public class AgenziaService extends AbstractService<Agenzia, AgenziaDTO>{

    private AgenziaDAO ageDAO;

    public AgenziaService(){
        this.dao = new AgenziaDAO();
        this.ageDAO=new AgenziaDAO() ;
        this.converter = new AgenziaConverter();
    }

    public AgenziaDTO findByFk(int adminId){
        return converter.toDTO(ageDAO.findByFk(adminId));
    }


}
