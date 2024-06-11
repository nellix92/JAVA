package it.contrader.converter;

import it.contrader.dto.AgenziaDTO;
import it.contrader.model.Agenzia;

import java.util.ArrayList;
import java.util.List;

public class AgenziaConverter implements Converter<Agenzia, AgenziaDTO>{


    @Override
    public AgenziaDTO toDTO(Agenzia agenzia) {
        return agenzia != null ? new AgenziaDTO(agenzia.getId(), agenzia.getNome(), agenzia.getDescrizione(), agenzia.getProvincia(), agenzia.getCitta(), agenzia.getIndirizzo(), agenzia.getAdmin_id()) : null;

    }

    public Agenzia toEntity(AgenziaDTO agenziaDTO){
        return agenziaDTO != null ? new Agenzia(agenziaDTO.getId(), agenziaDTO.getNome(), agenziaDTO.getDescrizione(), agenziaDTO.getProvincia(), agenziaDTO.getCitta(), agenziaDTO.getIndirizzo(), agenziaDTO.getAdmin_id()) : null;
    }

    public List<AgenziaDTO> toDTOList(List<Agenzia> agenziaList){
        List<AgenziaDTO> agenziaDTOList = new ArrayList<>();
        if(agenziaList != null){
            for (Agenzia agenzia : agenziaList){
                agenziaDTOList.add(toDTO(agenzia));
            }
            return agenziaDTOList;
        } else return null;
    }

}
