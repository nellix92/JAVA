package it.contrader.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "acquisti")
public class Acquisto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroOrdine;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private double prezzo;

    @OneToOne
    private Casa casa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "anagrafica_id")
    private Anagrafica anagrafica;
}
