package it.contrader.converter;

import it.contrader.dto.AcquistoDTO;
import it.contrader.model.Acquisto;
import it.contrader.model.Anagrafica;
import it.contrader.model.Casa;
import org.springframework.stereotype.Component;

@Component
public class AcquistoConverter extends AbstractConverter<Acquisto, AcquistoDTO>{
    @Override
    public Acquisto toEntity(AcquistoDTO acquistoDTO) {
        Casa c = new Casa();
        Anagrafica a = new Anagrafica();
        c.setId(acquistoDTO.getCasa_id());
        a.setId(acquistoDTO.getAnagrafica_id());
        return acquistoDTO != null ? Acquisto.builder()
                .id(acquistoDTO.getId())
                .data(acquistoDTO.getData())
                .prezzo(acquistoDTO.getPrezzo())
                .casa(c)
                .anagrafica(a)
                .build() : null;
    }

    @Override
    public AcquistoDTO toDTO(Acquisto acquisto) {
        return acquisto != null ? AcquistoDTO.builder()
                .id(acquisto.getId())
                .data(acquisto.getData())
                .prezzo(acquisto.getPrezzo())
                .casa_id(acquisto.getCasa().getId())
                .anagrafica_id(acquisto.getAnagrafica().getId())
                .build() : null;
    }

}
