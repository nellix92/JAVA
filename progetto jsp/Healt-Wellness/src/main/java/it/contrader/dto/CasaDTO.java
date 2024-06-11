package it.contrader.dto;

import java.util.Objects;

public class CasaDTO {

    private int id, id_agenzia;

    private String nome, indirizzo, metri_quadrati, costruita, dettagli, tipo;

    private double prezzo;

    private boolean disponibile;

    public CasaDTO() {
    }

    public CasaDTO(String nome, double prezzo, String indirizzo, String metri_quadrati, String costruita, String dettagli, String tipo, boolean disponibile, int id_agenzia) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.indirizzo = indirizzo;
        this.metri_quadrati = metri_quadrati;
        this.costruita = costruita;
        this.dettagli = dettagli;
        this.tipo = tipo;
        this.disponibile = disponibile;
        this.id_agenzia = id_agenzia;
    }

    public CasaDTO(int id, String nome, double prezzo, String indirizzo, String metri_quadrati, String costruita, String dettagli, String tipo, boolean disponibile, int id_agenzia) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.indirizzo = indirizzo;
        this.metri_quadrati = metri_quadrati;
        this.costruita = costruita;
        this.dettagli = dettagli;
        this.tipo = tipo;
        this.disponibile = disponibile;
        this.id_agenzia = id_agenzia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_agenzia() {
        return id_agenzia;
    }

    public void setId_agenzia(int id_agenzia) {
        this.id_agenzia = id_agenzia;
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
        this.prezzo = prezzo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return "CasaDTO{" +
                "id=" + id +
                ", id_agenzia=" + id_agenzia +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", metri_quadrati='" + metri_quadrati + '\'' +
                ", costruita='" + costruita + '\'' +
                ", dettagli='" + dettagli + '\'' +
                ", tipo='" + tipo + '\'' +
                ", prezzo=" + prezzo +
                ", disponibile=" + disponibile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CasaDTO casaDTO = (CasaDTO) o;
        return id == casaDTO.id && id_agenzia == casaDTO.id_agenzia && Objects.equals(nome, casaDTO.nome) && Objects.equals(indirizzo, casaDTO.indirizzo) && Objects.equals(metri_quadrati, casaDTO.metri_quadrati) && Objects.equals(costruita, casaDTO.costruita) && Objects.equals(dettagli, casaDTO.dettagli) && Objects.equals(tipo, casaDTO.tipo) && Objects.equals(prezzo, casaDTO.prezzo) && Objects.equals(disponibile, casaDTO.disponibile);
    }

}