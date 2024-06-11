package it.contrader.dto;

import it.contrader.model.Casa.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CasaDTO {
    private Long id;

    private String nome;

    private int metratura;

    private double prezzo;

    private String codice;

    private String descrizione;

    private Tipo tipo;

    private int costruita;

    private boolean disponibile = true;

    private Long idAgenzia;
}
