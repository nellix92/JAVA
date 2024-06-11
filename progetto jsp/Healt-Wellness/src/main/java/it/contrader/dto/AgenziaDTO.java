package it.contrader.dto;

public class AgenziaDTO {

    private int id, admin_id;

    private String nome, descrizione, provincia, citta, indirizzo;

    public AgenziaDTO() {
    }

    public AgenziaDTO(int id, String nome, String descrizione, String provincia, String citta, String indirizzo, int admin_id) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.provincia = provincia;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.admin_id = admin_id;
    }

    public AgenziaDTO(String nome, String descrizione, String provincia, String citta, String indirizzo, int adminId) {
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
        return "AgenziaDTO{" +
                "id=" + id +
                ", admin_id=" + admin_id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", provincia='" + provincia + '\'' +
                ", citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
