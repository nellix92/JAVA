package it.contrader.dto;

public class AcquistoDTO {

    private int id, user_id;

    private String nome;

    private double prezzo;

    private int casa_id;

    public AcquistoDTO() {
    }

    public AcquistoDTO(int user_id, String nome, double prezzo, int casa_id) {
        this.user_id = user_id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.casa_id = casa_id;
    }

    public AcquistoDTO(int id, int user_id, String nome, double prezzo, int casa_id) {
        this.id = id;
        this.user_id = user_id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.casa_id = casa_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "AcquistoDTO{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", casa_id=" + casa_id +
                '}';
    }
}
