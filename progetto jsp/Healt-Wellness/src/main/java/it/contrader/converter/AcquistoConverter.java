package it.contrader.converter;

import it.contrader.dto.AcquistoDTO;
import it.contrader.model.Acquisto;

import java.util.ArrayList;
import java.util.List;

public class AcquistoConverter implements Converter<Acquisto, AcquistoDTO>{
    @Override
    public AcquistoDTO toDTO(Acquisto a) {
        AcquistoDTO acquistoDTO = new AcquistoDTO(a.getId(), a.getAnagrafica_id(), a.getNome_casa(), a.getPrezzo(), a.getCasa_id());
        return acquistoDTO;
    }

    @Override
    public Acquisto toEntity(AcquistoDTO a) {
        Acquisto acquisto = new Acquisto(a.getId(), a.getAnagrafica_id(), a.getNome_casa(), a.getPrezzo(), a.getCasa_id());
        return acquisto;
    }

    @Override
    public List<AcquistoDTO> toDTOList(List<Acquisto> acquistoList) {
        List<AcquistoDTO> acquistoDTOList = new ArrayList<>();
        for(Acquisto a : acquistoList){
            acquistoDTOList.add(toDTO(a));
        }

        return acquistoDTOList;
    }
}
