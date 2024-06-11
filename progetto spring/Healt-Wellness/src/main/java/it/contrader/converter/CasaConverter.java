package it.contrader.converter;

import it.contrader.dto.CasaDTO;
import it.contrader.model.Agenzia;
import it.contrader.model.Casa;
import org.springframework.stereotype.Component;

@Component
public class CasaConverter extends AbstractConverter<Casa, CasaDTO> {
    @Override
    public Casa toEntity(CasaDTO casaDTO) {
        Agenzia agenzia = new Agenzia();
        agenzia.setId(casaDTO.getAgenzia_id());

        return casaDTO != null ? Casa.builder()
                .id(casaDTO.getId())
                .nome(casaDTO.getNome())
                .prezzo(casaDTO.getPrezzo())
                .indirizzo(casaDTO.getIndirizzo())
                .metratura(casaDTO.getMetratura())
                .costruita(casaDTO.getCostruita())
                .dettagli(casaDTO.getDettagli())
                .tipo(casaDTO.getTipo())
                .disponibile(casaDTO.isDisponibile())
                .agenzia(agenzia)
                .build() : null;
    }

    @Override
    public CasaDTO toDTO(Casa casa) {
        return casa != null ? CasaDTO.builder()
                .id(casa.getId())
                .nome(casa.getNome())
                .prezzo(casa.getPrezzo())
                .indirizzo(casa.getIndirizzo())
                .metratura(casa.getMetratura())
                .costruita(casa.getCostruita())
                .dettagli(casa.getDettagli())
                .tipo(casa.getTipo())
                .disponibile(casa.isDisponibile())
                .agenzia_id(casa.getAgenzia().getId())
                .build() : null;
    }
}
