package it.contrader.converter;

import it.contrader.dto.AcquistoDTO;
import it.contrader.model.Acquisto;

import java.util.ArrayList;
import java.util.List;

public class AcquistoConverter {

    public AcquistoDTO toDTO(Acquisto acquisto){
        return acquisto != null ? new AcquistoDTO(acquisto.getId(), acquisto.getUser_id(), acquisto.getNome(), acquisto.getPrezzo(), acquisto.getCasa_id()) : null;
    }

    public Acquisto toEntity(AcquistoDTO acquistoDTO){
        return acquistoDTO != null ? new Acquisto(acquistoDTO.getId(), acquistoDTO.getUser_id(), acquistoDTO.getNome(), acquistoDTO.getPrezzo(), acquistoDTO.getCasa_id()) : null;
    }

    public List<AcquistoDTO> toDTOList(List<Acquisto> acquistoList){
        List<AcquistoDTO> acquistoDTOList = new ArrayList<>();
        if(acquistoList != null){
            for (Acquisto a : acquistoList){
                acquistoDTOList.add(toDTO(a));
            }
            return acquistoDTOList;
        }else return null;
    }
}
