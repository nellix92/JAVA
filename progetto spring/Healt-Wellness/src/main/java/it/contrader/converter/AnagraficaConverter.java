package it.contrader.converter;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.User;
import org.springframework.stereotype.Component;

@Component
public class AnagraficaConverter extends AbstractConverter<Anagrafica, AnagraficaDTO>{
    @Override
    public Anagrafica toEntity(AnagraficaDTO anagraficaDTO) {
        User u = new User();
        u.setId(anagraficaDTO.getUser_id());
        return anagraficaDTO !=  null ? Anagrafica.builder()
                .id(anagraficaDTO.getId())
                .nome(anagraficaDTO.getNome())
                .cognome(anagraficaDTO.getCognome())
                .email(anagraficaDTO.getEmail())
                .dataDiNascita(anagraficaDTO.getDataDiNascita())
                .genere(anagraficaDTO.getGenere())
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
                .email(anagrafica.getEmail())
                .dataDiNascita(anagrafica.getDataDiNascita())
                .genere(anagrafica.getGenere())
                .nazione(anagrafica.getNazione())
                .provincia(anagrafica.getProvincia())
                .citta(anagrafica.getCitta())
                .indirizzo(anagrafica.getIndirizzo())
                .user_id(anagrafica.getUser() != null ? anagrafica.getUser().getId() : null)
                .build() : null;
    }
}
