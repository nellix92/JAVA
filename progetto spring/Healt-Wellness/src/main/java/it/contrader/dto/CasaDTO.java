package it.contrader.dto;

import it.contrader.model.Casa.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CasaDTO {

    private Long id;

    private String nome;

    private double prezzo;

    private String indirizzo;

    private int metratura;

    private int costruita;

    private String dettagli;

    private Tipo tipo;

    private boolean disponibile;

    private Long agenzia_id;
}
