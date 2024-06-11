package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "casa")
public class Casa {

    public enum Tipo{
        APPARTAMENTO, VILLA, LOFT,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int metratura;

    @Column(nullable = false)
    private Double prezzo;

    @Column(nullable = false)
    private String codice;

    @Column(nullable = false)
    private String descrizione;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(nullable = false)
    private int costruita;

    @Column(nullable = false)
    @ColumnDefault("true")
    private boolean disponibile;

    @ManyToOne
    @JoinColumn(name = "agenzia_id")
    private Agenzia agenzia;
}
