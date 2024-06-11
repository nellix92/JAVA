package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ImmagineDTO {

    private Long id;

    private String url;

    private Long casaId;

    private Long userId;

}
