package it.contrader.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "anagrafiche")
public class Anagrafica {
    public enum Genere {
        UOMO, DONNA, ALTRO
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Enumerated(EnumType.STRING)
    private Genere genere;

    @Column(nullable = false)
    private String codiceFiscale;

    @Column(nullable = false)
    private LocalDate nascita;

    @Column(nullable = false)
    private String nazione;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String citta;

    @Column(nullable = false)
    private String indirizzo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
