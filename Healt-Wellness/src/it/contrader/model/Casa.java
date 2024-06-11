package it.contrader.model;

import java.util.Objects;

public class Casa {

    private int id, agenzia_id;

    private String nome, indirizzo, metri_quadrati, costruita, dettagli, tipo;

    private double prezzo;

    public Casa() {
    }

    public Casa(String nome, double prezzo, String indirizzo, String metri_quadrati, String costruita, String dettagli, String tipo, int agenzia_id) {
        this.agenzia_id = agenzia_id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.indirizzo = indirizzo;
        this.metri_quadrati = metri_quadrati;
        this.costruita = costruita;
        this.dettagli = dettagli;
        this.tipo = tipo;
    }

    public Casa(int id, String nome,double prezzo, String indirizzo, String metri_quadrati, String costruita, String dettagli, String tipo,  int agenzia_id) {
        this.id = id;
        this.agenzia_id = agenzia_id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.metri_quadrati = metri_quadrati;
        this.costruita = costruita;
        this.dettagli = dettagli;
        this.tipo = tipo;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgenzia_id() {
        return agenzia_id;
    }

    public void setAgenzia_id(int agenzia_id) {
        this.agenzia_id = agenzia_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getMetri_quadrati() {
        return metri_quadrati;
    }

    public void setMetri_quadrati(String metri_quadrati) {
        this.metri_quadrati = metri_quadrati;
    }

    public String getCostruita() {
        return costruita;
    }

    public void setCostruita(String costruita) {
        this.costruita = costruita;
    }

    public String getDettagli() {
        return dettagli;
    }

    public void setDettagli(String dettagli) {
        this.dettagli = dettagli;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {

        System.out.println("ciaociao");this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "id=" + id +
                ", agenzia_id=" + agenzia_id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", metri_quadrati='" + metri_quadrati + '\'' +
                ", costruita='" + costruita + '\'' +
                ", dettagli='" + dettagli + '\'' +
                ", tipo='" + tipo + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casa casa = (Casa) o;
        return id == casa.id && agenzia_id == casa.agenzia_id && Objects.equals(nome, casa.nome) && Objects.equals(indirizzo, casa.indirizzo) && Objects.equals(metri_quadrati, casa.metri_quadrati) && Objects.equals(costruita, casa.costruita) && Objects.equals(dettagli, casa.dettagli) && Objects.equals(tipo, casa.tipo) && Objects.equals(prezzo, casa.prezzo);
    }

}
