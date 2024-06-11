package it.contrader.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgenziaDTO {

    private Long id;
    private String nome;
    private String indirizzo;
    private String nazione;
    private String provincia;
    private String citta;
    private String descrizione;
    private Long adminId;
}
