package it.contrader.dto;

import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AgenziaDTO {

    private Long id;

    private String nome;

    private String descrizione;

    private String provincia;

    private String citta;

    private String indirizzo;

    private Long admin_id;

}
