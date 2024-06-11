package it.contrader.converter;
import it.contrader.dto.AcquistoDTO;
import it.contrader.model.Acquisto;
import it.contrader.model.Anagrafica;
import it.contrader.model.Casa;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AcquistoConverter extends AbstractConverter<Acquisto, AcquistoDTO>{
    @Override
    public Acquisto toEntity(AcquistoDTO acquistoDTO) {
        Casa casaList = new Casa();
        casaList.setId(acquistoDTO.getCasaId());
        Anagrafica a = new Anagrafica();
        a.setId(acquistoDTO.getAnagraficaId());
             return acquistoDTO != null ? Acquisto
                .builder()
                .id(acquistoDTO.getId())
                .numeroOrdine(acquistoDTO.getNumeroOrdine())
                .data(acquistoDTO.getData())
                .prezzo(acquistoDTO.getPrezzo())
                .casa(casaList)
                .anagrafica(a)
                .build() : null;
    }
    @Override
    public AcquistoDTO toDTO(Acquisto acquisto) {
        return acquisto != null ? AcquistoDTO
                .builder()
                .id(acquisto.getId())
                .numeroOrdine(acquisto.getNumeroOrdine())
                .data(acquisto.getData())
                .prezzo(acquisto.getPrezzo())
                .casaId(acquisto.getCasa().getId())
                .anagraficaId(acquisto.getAnagrafica().getId())
                .build() : null;
    }
    public Page<AcquistoDTO> toDtoPage(Page<Acquisto> acquistoPage){
        return acquistoPage.map(this::toDTO);
    }
}
