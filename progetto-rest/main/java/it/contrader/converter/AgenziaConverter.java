package it.contrader.converter;
import it.contrader.dto.AgenziaDTO;
import it.contrader.model.Agenzia;
import it.contrader.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class AgenziaConverter extends AbstractConverter<Agenzia, AgenziaDTO> {
    @Override
    public Agenzia toEntity(AgenziaDTO agenziaDTO) {
        User user =new User();
        user.setId(agenziaDTO.getAdminId());
        return agenziaDTO != null ?Agenzia.builder()
                .id(agenziaDTO.getId())
                .nome(agenziaDTO.getNome())
                .indirizzo(agenziaDTO.getIndirizzo())
                .nazione(agenziaDTO.getNazione())
                .provincia(agenziaDTO.getProvincia())
                .citta(agenziaDTO.getCitta())
                .descrizione(agenziaDTO.getDescrizione())
                .admin(user)
                .build() : null;
    }
    @Override
    public AgenziaDTO toDTO(Agenzia agenzia) {
        return agenzia != null ? AgenziaDTO.builder()
                .id(agenzia.getId())
                .nome(agenzia.getNome())
                .indirizzo(agenzia.getIndirizzo())
                .nazione(agenzia.getNazione())
                .provincia(agenzia.getProvincia())
                .citta(agenzia.getCitta())
                .descrizione(agenzia.getDescrizione())
                .adminId(agenzia.getAdmin().getId())
                .build() : null;
    }
    public Page<AgenziaDTO> toDTOPage(Page<Agenzia> agenziaPage){
        return  agenziaPage.map(this::toDTO);
    }
}
