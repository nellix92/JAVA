package it.contrader.converter;
import it.contrader.dto.CasaDTO;
import it.contrader.model.Agenzia;
import it.contrader.model.Casa;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class CasaConverter extends AbstractConverter<Casa, CasaDTO> {
    @Override
    public Casa toEntity(CasaDTO casaDTO){
        Agenzia agenzia = new Agenzia();
        agenzia.setId(casaDTO.getIdAgenzia());
        return casaDTO != null ? Casa.builder()
                .id(casaDTO.getId())
                .nome(casaDTO.getNome())
                .metratura(casaDTO.getMetratura())
                .prezzo(casaDTO.getPrezzo())
                .codice(casaDTO.getCodice())
                .descrizione(casaDTO.getDescrizione())
                .tipo(casaDTO.getTipo())
                .costruita(casaDTO.getCostruita())
                .disponibile(casaDTO.isDisponibile())
                .agenzia(agenzia)
                .build() : null;
    }
    @Override
    public CasaDTO toDTO(Casa casa) {
        return CasaDTO.builder()
                .id(casa.getId())
                .nome(casa.getNome())
                .metratura(casa.getMetratura())
                .prezzo(casa.getPrezzo())
                .codice(casa.getCodice())
                .descrizione(casa.getDescrizione())
                .tipo(casa.getTipo())
                .costruita(casa.getCostruita())
                .disponibile(casa.isDisponibile())
                .idAgenzia(casa.getAgenzia().getId())
                .build();
    }
    public Page<CasaDTO> toDTOPage(Page<Casa> casaPage){return casaPage.map(this::toDTO);}
}
