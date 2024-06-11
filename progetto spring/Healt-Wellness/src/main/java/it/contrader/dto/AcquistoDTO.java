package it.contrader.dto;

import it.contrader.model.Casa;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AcquistoDTO {

    private Long id;

    private LocalDate data;

    private double prezzo;

    private Long casa_id;

    private Long anagrafica_id;

}
