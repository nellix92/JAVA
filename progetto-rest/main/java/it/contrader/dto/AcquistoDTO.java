package it.contrader.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AcquistoDTO {
    private Long id;
    private String numeroOrdine;
    private LocalDate data;
    private double prezzo;
    private Long casaId;
    private Long anagraficaId;
}
