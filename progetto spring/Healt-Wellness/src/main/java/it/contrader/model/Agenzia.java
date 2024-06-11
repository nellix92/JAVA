package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor //costruttore con tutti i campi
@NoArgsConstructor //costruttore vuoto
@Builder //metodo builder
@Data //getters setters toString ecc
@Entity
@Table(name = "agenzia")
public class Agenzia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descrizione;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String citta;

    @Column(nullable = false)
    private String indirizzo;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private User admin;

}
