package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "anagrafica")
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

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    private Genere genere;

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
