package it.contrader.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarrelloDTO {
    private Long id;
    private Double totale;
    private List<Long> casaId;
    private Long user_id;
}
