package it.contrader.model;


import java.util.Objects;

/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Anagrafica {

    /**
     * Qui sotto definisco gli attributi di Anagrafica.
     */
    private int id;

    private String nome;

    private String cognome;


    private String email;


    private String dataDiNascita;

    private String genere;


    private String nazione;

    private String provincia;


    private String citta;

    private String indirizzo;

    private int userId;

    //--------------------------------------------------------------------------------------------------------------
    //COSTRUTTORI

    //costruttore senza parametri
    public Anagrafica() {

    }

    //costruttore con tutti i parametri
    public Anagrafica(int id, String nome, String cognome,
                      String email, String dataDiNascita,
                      String genere,
                      String nazione, String provincia,
                      String citta, String indirizzo, int userId) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.genere = genere;
        this.nazione = nazione;
        this.provincia = provincia;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.userId = userId;
    }


    //costruttore con tutti i parametri tranne id
    public Anagrafica(String nome, String cognome, String email, String dataDiNascita, String genere, String nazione, String provincia, String citta, String indirizzo, int userId) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.genere = genere;
        this.nazione = nazione;
        this.provincia = provincia;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.userId = userId;
    }

    //--------------------------------------------------------------------------------------------------------------

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //--------------------------------------------------------------------------------------------------------------


    //Trasforma un oggetto in una stringa
    @Override
    public String toString() {
        return "Anagrafica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita='" + dataDiNascita + '\'' +
                ", genere='" + genere + '\'' +
                ", nazione='" + nazione + '\'' +
                ", provincia='" + provincia + '\'' +
                ", citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", userId=" + userId +
                '}';
    }


    //--------------------------------------------------------------------------------------------------------------


    //Metodo per il confronto degli oggetti
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anagrafica)) return false;
        Anagrafica that = (Anagrafica) o;
        return getId() == that.getId() && getUserId() == that.getUserId() && Objects.equals(getNome(), that.getNome()) && Objects.equals(getCognome(), that.getCognome()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getDataDiNascita(), that.getDataDiNascita()) && Objects.equals(getNazione(), that.getNazione()) && Objects.equals(getProvincia(), that.getProvincia()) && Objects.equals(getCitta(), that.getCitta()) && Objects.equals(getIndirizzo(), that.getIndirizzo());
    }


    //--------------------------------------------------------------------------------------------------------------

}
