package it.contrader.dto;
import it.contrader.model.Anagrafica.Genere;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnagraficaDTO {
    private Long id;
    private String nome;
    private String cognome;
    private Genere genere;
    private String codiceFiscale;
    private LocalDate nascita;
    private String nazione;
    private String provincia;
    private String citta;
    private String indirizzo;
    private Long user_id;
}
