package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;

    public class AnagraficaConverter  implements Converter<Anagrafica, AnagraficaDTO> {
        @Override
        public AnagraficaDTO toDTO(Anagrafica anagrafica) {
            AnagraficaDTO anagraficaDTO = new AnagraficaDTO(anagrafica.getId(), anagrafica.getNome(), anagrafica.getCognome(), anagrafica.getEmail(), anagrafica.getDataDiNascita(), anagrafica.getGenere(), anagrafica.getNazione(), anagrafica.getProvincia(), anagrafica.getCitta(), anagrafica.getIndirizzo(), anagrafica.getUserId());

            return anagraficaDTO;
        }
        //-------------------------------------------------------------------------------------------------------------
        @Override
        public Anagrafica toEntity(AnagraficaDTO anagraficaDTO) {
            Anagrafica anagrafica = new Anagrafica(anagraficaDTO.getId(), anagraficaDTO.getNome(), anagraficaDTO.getCognome(), anagraficaDTO.getEmail(), anagraficaDTO.getDataDiNascita(), anagraficaDTO.getGenere(), anagraficaDTO.getNazione(), anagraficaDTO.getProvincia(), anagraficaDTO.getCitta(), anagraficaDTO.getIndirizzo(),anagraficaDTO.getUserId());
            return anagrafica;
        }

        //------------------------------------------------------------------------------------------------------
        @Override
        public List<AnagraficaDTO> toDTOList(List<Anagrafica> anagraficaList) {

            List<AnagraficaDTO> anagraficaDTOList = new ArrayList<>();

            for(Anagrafica anagrafica : anagraficaList) {
                anagraficaDTOList.add(toDTO(anagrafica));
            }
            return anagraficaDTOList;
        }



        //-------------------------------------------------------------------------------------------------------------



    }


