package it.contrader.converter;

import it.contrader.dto.CasaDTO;
import it.contrader.model.Casa;

import java.util.ArrayList;
import java.util.List;

public class CasaConverter implements Converter<Casa, CasaDTO> {
    @Override
    public CasaDTO toDTO(Casa casa){
        return casa != null ? new CasaDTO(casa.getId(), casa.getNome(), casa.getPrezzo(), casa.getIndirizzo(), casa.getMetri_quadrati(), casa.getCostruita(), casa.getDettagli(), casa.getTipo(), casa.isDisponibile(), casa.getId_agenzia()) : null;
    }
    @Override
    public Casa toEntity(CasaDTO casaDTO){
        return casaDTO != null ? new Casa(casaDTO.getId(),  casaDTO.getId_agenzia(), casaDTO.getNome(), casaDTO.getPrezzo(), casaDTO.getIndirizzo(), casaDTO.getMetri_quadrati(), casaDTO.getCostruita(), casaDTO.getDettagli(), casaDTO.getTipo(), casaDTO.isDisponibile()) : null;
    }
    @Override
    public List<CasaDTO> toDTOList(List<Casa> casaList){
        List<CasaDTO> casaDTOList = new ArrayList<>();
        if(casaList != null){
            for(Casa casa : casaList){
                casaDTOList.add(toDTO(casa));
            }
            return casaDTOList;
        } else return null;
    }
}