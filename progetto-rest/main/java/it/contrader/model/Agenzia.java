package it.contrader.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "agenzie")
public class Agenzia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String nazione;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String citta;

    @Column(nullable = false)
    private String descrizione;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private User admin;
}
