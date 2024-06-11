package it.contrader.converter;

import it.contrader.dto.ImmagineDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.Casa;
import it.contrader.model.Immagine;
import it.contrader.model.User;
import org.springframework.stereotype.Component;

@Component
public class ImmagineConverter extends AbstractConverter<Immagine, ImmagineDTO>{

    @Override
    public Immagine toEntity(ImmagineDTO immagineDTO){
        Casa casa = new Casa();
        casa.setId(immagineDTO.getCasaId());
        User user = new User();
        user.setId(immagineDTO.getUserId());
        return immagineDTO != null ? Immagine
                .builder()
                .id(immagineDTO.getId())
                .url(immagineDTO.getUrl())
                .casa(casa)
                .user(user)
                .build() : null;
   }

   @Override
   public ImmagineDTO toDTO(Immagine immagine){
      return immagine != null ? ImmagineDTO
              .builder()
              .id(immagine.getId())
              .url(immagine.getUrl())
              .casaId(immagine.getCasa().getId())
              .userId(immagine.getUser().getId())
              .build() : null;
   }

}
