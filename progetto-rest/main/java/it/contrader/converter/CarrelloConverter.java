package it.contrader.converter;
import it.contrader.dto.CarrelloDTO;
import it.contrader.model.Carrello;
import it.contrader.model.Casa;
import it.contrader.model.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarrelloConverter extends AbstractConverter<Carrello, CarrelloDTO> {
    @Override
    public Carrello toEntity(CarrelloDTO carrelloDTO) {
        List<Casa> casaList = new ArrayList<>();
        User u = new User();
        u.setId(carrelloDTO.getUser_id());
        for(Long id : carrelloDTO.getCasaId()){
            Casa c = new Casa();
            c.setId(id);
            casaList.add(c);
        }
        return carrelloDTO != null ? Carrello
                .builder()
                .id(carrelloDTO.getId())
                .totale(carrelloDTO.getTotale())

                .listaCarrello(casaList)
                .admin(u)
                .build() : null;
    }
    @Override
    public CarrelloDTO toDTO(Carrello carrello) {
        List<Long> caseId = new ArrayList<>();
        for(Casa c : carrello.getListaCarrello()){
            caseId.add(c.getId());
        }
        return carrello != null ? CarrelloDTO
                .builder()
                .id(carrello.getId())
                .totale(carrello.getTotale())
                .casaId(caseId)
                .user_id(carrello.getAdmin().getId())
                .build() : null;
    }
}
