package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "casa")
public class Casa {

    public void addAttribute(String result, List<Casa> result1) {
    }

    public enum Tipo{
        MONOLOCALE, BILOCALE, LOFT, VILLA, APPARTAMENTO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double prezzo;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private int metratura;

    @Column(nullable = false)
    private int costruita;

    @Column(nullable = false)
    private String dettagli;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(nullable = false)
    private boolean disponibile;

    @ManyToOne
    @JoinColumn(name = "agenzia_id")
    private Agenzia agenzia;

}
