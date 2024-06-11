package it.contrader.model;

import java.util.Objects;

public class Agenzia {

    private int id, admin_id;

    private String nome, descrizione, provincia, citta, indirizzo;

    public Agenzia() {
    }

    public Agenzia(int id, String nome, String descrizione, String provincia, String citta, String indirizzo, int admin_id) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.provincia = provincia;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.admin_id = admin_id;
    }

    public Agenzia(String nome, String descrizione, String provincia, String citta, String indirizzo, int adminId) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.provincia = provincia;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.admin_id = adminId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "Agenzia{" +
                "id=" + id +
                ", admin_id=" + admin_id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", provincia='" + provincia + '\'' +
                ", città='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenzia agenzia = (Agenzia) o;
        return id == agenzia.id && admin_id == agenzia.admin_id && Objects.equals(nome, agenzia.nome) && Objects.equals(descrizione, agenzia.descrizione) && Objects.equals(provincia, agenzia.provincia) && Objects.equals(citta, agenzia.citta) && Objects.equals(indirizzo, agenzia.indirizzo);
    }
}
