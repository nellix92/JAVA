package it.contrader.converter;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class AnagraficaConverter extends AbstractConverter<Anagrafica, AnagraficaDTO>{
    @Override
    public Anagrafica toEntity(AnagraficaDTO anagraficaDTO) {
        User u = new User();
        u.setId(anagraficaDTO.getUser_id());
        return anagraficaDTO != null ? Anagrafica.builder()
                .id(anagraficaDTO.getId())
                .nome(anagraficaDTO.getNome())
                .cognome(anagraficaDTO.getCognome())
                .genere(anagraficaDTO.getGenere())
                .codiceFiscale(anagraficaDTO.getCodiceFiscale())
                .nascita(anagraficaDTO.getNascita())
                .nazione(anagraficaDTO.getNazione())
                .provincia(anagraficaDTO.getProvincia())
                .citta(anagraficaDTO.getCitta())
                .indirizzo(anagraficaDTO.getIndirizzo())
                .user(u)
                .build() : null;
    }
    @Override
    public AnagraficaDTO toDTO(Anagrafica anagrafica) {
        return anagrafica != null ? AnagraficaDTO.builder()
                .id(anagrafica.getId())
                .nome(anagrafica.getNome())
                .cognome(anagrafica.getCognome())
                .genere(anagrafica.getGenere())
                .codiceFiscale(anagrafica.getCodiceFiscale())
                .nascita(anagrafica.getNascita())
                .nazione(anagrafica.getNazione())
                .provincia(anagrafica.getProvincia())
                .citta(anagrafica.getCitta())
                .indirizzo(anagrafica.getIndirizzo())
                .user_id(anagrafica.getUser().getId())
                .build() : null;
    }
    public Page<AnagraficaDTO> toDTOPage(Page<Anagrafica> anagraficaPage){return anagraficaPage.map(this::toDTO);}
}
