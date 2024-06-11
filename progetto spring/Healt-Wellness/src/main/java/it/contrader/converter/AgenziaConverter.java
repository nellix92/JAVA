package it.contrader.converter;


import it.contrader.dto.AgenziaDTO;
import it.contrader.model.Agenzia;
import it.contrader.model.User;
import org.springframework.stereotype.Component;

@Component
public class AgenziaConverter extends AbstractConverter<Agenzia, AgenziaDTO>{

/*
    @Override
    public Agenzia toEntity(AgenziaDTO agenziaDTO) {
        User u = new Agenzia().getAdmin();
        u.setId(agenziaDTO.getAdmin_id());
        return agenziaDTO != null ? Agenzia.builder()
                .id(agenziaDTO.getId())
                .nome(agenziaDTO.getNome())
                .descrizione(agenziaDTO.getDescrizione())
                .provincia(agenziaDTO.getProvincia())
                .indirizzo(agenziaDTO.getIndirizzo())
                .citta(agenziaDTO.getCitta())
                .admin(u)
                .build() : null;
    }

    //non funziona
*/

    @Override
    public Agenzia toEntity(AgenziaDTO agenziaDTO) {
        User u = new User();
        u.setId(agenziaDTO.getAdmin_id());

        return agenziaDTO != null ? Agenzia.builder()
                .id(agenziaDTO.getId())
                .nome(agenziaDTO.getNome())
                .descrizione(agenziaDTO.getDescrizione())
                .provincia(agenziaDTO.getProvincia())
                .indirizzo(agenziaDTO.getIndirizzo())
                .citta(agenziaDTO.getCitta())
                .admin(u)
                .build() : null;
    }

    @Override
    public AgenziaDTO toDTO(Agenzia agenzia) {
        return agenzia != null? AgenziaDTO.builder()
                .id(agenzia.getId())
                .nome(agenzia.getNome())
                .descrizione(agenzia.getDescrizione())
                .provincia(agenzia.getProvincia())
                .indirizzo(agenzia.getIndirizzo())
                .citta(agenzia.getCitta())
                .admin_id(agenzia.getAdmin().getId())
                .build() : null;
    }
}
