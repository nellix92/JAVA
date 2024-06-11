package it.contrader.dto;

import it.contrader.model.Anagrafica.Genere;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnagraficaDTO {

    private Long id;

    private String nome;

    private String cognome;

    private String email;

    private LocalDate dataDiNascita;

    private Genere genere;

    private String nazione;

    private String provincia;

    private String citta;

    private String indirizzo;

    private Long user_id;

}
