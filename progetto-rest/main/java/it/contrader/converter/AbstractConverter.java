package it.contrader.converter;

import it.contrader.dto.AcquistoDTO;
import it.contrader.model.Acquisto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public abstract class AbstractConverter<Entity, DTO> implements Converter<Entity, DTO> {

    public List<Entity> toEntityList(List<DTO> listDTO) {
        return listDTO.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public List<DTO> toDTOList(List<Entity> listEntity) {
        return listEntity.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Page<DTO> toDtoPage(Page<Entity> acquistoPage){
        return acquistoPage.map(this::toDTO);
    }
}
