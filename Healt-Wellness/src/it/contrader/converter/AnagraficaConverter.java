package it.contrader.converter;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;

import java.util.ArrayList;
import java.util.List;

public class AnagraficaConverter {

    public AnagraficaDTO toDTO(Anagrafica anagrafica){
        return anagrafica != null ? new AnagraficaDTO(
                anagrafica.getId(),
                anagrafica.getCognome(),
                anagrafica.getNome(),
                anagrafica.getEmail(),
                anagrafica.getGenere(),
                anagrafica.getDataDiNascita(),
                anagrafica.getNazione(),
                anagrafica.getProvincia(),
                anagrafica.getCitta(),
                anagrafica.getIndirizzo(),
                anagrafica.getIdUser()): null;
    }

    public Anagrafica toEntity(AnagraficaDTO anagraficaDTO){
        return anagraficaDTO != null ? new Anagrafica(
                anagraficaDTO.getId(),
                anagraficaDTO.getCognome(),
                anagraficaDTO.getNome(),
                anagraficaDTO.getEmail(),
                anagraficaDTO.getDataDiNascita(),
                anagraficaDTO.getGenere(),
                anagraficaDTO.getNazione(),
                anagraficaDTO.getProvincia(),
                anagraficaDTO.getCitta(),
                anagraficaDTO.getIndirizzo(),
                anagraficaDTO.getIdUser()): null;
    }

    public List<AnagraficaDTO> toDTOList(List<Anagrafica> anagraficaList) {
        List<AnagraficaDTO> anagraficaDTOList = new ArrayList<>();
        if(anagraficaList != null) {
            for (Anagrafica anagrafica : anagraficaList) {
                anagraficaDTOList.add(toDTO(anagrafica));
            }
            return anagraficaDTOList;
        } else return null;
    }
}
