package it.contrader.converter;

import it.contrader.dto.CasaDTO;
import it.contrader.model.Casa;

import java.util.ArrayList;
import java.util.List;

public class CasaConverter {

    public CasaDTO toDto(Casa casa){
        return casa != null ? new CasaDTO(casa.getId(), casa.getNome(), casa.getPrezzo(), casa.getIndirizzo(), casa.getMetri_quadrati(), casa.getCostruita(), casa.getDettagli(), casa.getTipo(), casa.getAgenzia_id()) : null;
    }

    public Casa toEntity(CasaDTO casaDto){
        return casaDto != null ? new Casa(casaDto.getId(), casaDto.getNome(), casaDto.getPrezzo(), casaDto.getIndirizzo(), casaDto.getMetri_quadrati(), casaDto.getCostruita(), casaDto.getDettagli(), casaDto.getTipo(), casaDto.getAgenzia_id()) : null;
    }

    public List<CasaDTO> toDTOList(List<Casa> casaList){
        List<CasaDTO> casaDTOList = new ArrayList<>();
        if(casaList != null){
            for(Casa casa : casaList){
                casaDTOList.add(toDto(casa));
            }
            return casaDTOList;
        } else return null;
    }
}
