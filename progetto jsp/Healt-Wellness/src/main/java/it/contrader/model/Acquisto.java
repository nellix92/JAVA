package it.contrader.model;

public class Acquisto {

    private int id;
    private int anagrafica_id;
    private String nome_casa;
    private double prezzo;
    private int casa_id;

    public Acquisto() {
    }

    public Acquisto(int anagrafica_id, String nome_casa, double prezzo, int casa_id) {
        this.anagrafica_id = anagrafica_id;
        this.nome_casa = nome_casa;
        this.prezzo = prezzo;
        this.casa_id = casa_id;
    }

    public Acquisto(int id, int anagrafica_id, String nome_casa, double prezzo, int casa_id) {
        this.id = id;
        this.anagrafica_id = anagrafica_id;
        this.nome_casa = nome_casa;
        this.prezzo = prezzo;
        this.casa_id = casa_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnagrafica_id() {
        return anagrafica_id;
    }

    public void setAnagrafica_id(int anagrafica_id) {
        this.anagrafica_id = anagrafica_id;
    }

    public String getNome_casa() {
        return nome_casa;
    }

    public void setNome_casa(String nome_casa) {
        this.nome_casa = nome_casa;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getCasa_id() {
        return casa_id;
    }

    public void setCasa_id(int casa_id) {
        this.casa_id = casa_id;
    }

    @Override
    public String toString() {
        return "Acquisto{" +
                "id=" + id +
                ", anagrafica_id=" + anagrafica_id +
                ", nome_casa='" + nome_casa + '\'' +
                ", prezzo=" + prezzo +
                ", casa_id=" + casa_id +
                '}';
    }
}
