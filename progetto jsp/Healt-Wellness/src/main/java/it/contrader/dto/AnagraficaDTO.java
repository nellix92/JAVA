package it.contrader.dto;


import it.contrader.model.Anagrafica;

/**
 *
 * @author Vittorio
 *
 *Il DTO � simile al Model ma pu� contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service).
 *Per la descrizione della classe far riferimento al Model "Anagrafica".
 */
public class AnagraficaDTO {



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

    //-------------------------------------------------------------------------------------------------------------
    //COSTRUTTORI

    public AnagraficaDTO() {

    }

    public AnagraficaDTO(String nome, String cognome, String email, String dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;


    }

    public AnagraficaDTO(int id, String nome, String cognome, String email, String dataDiNascita, String genere, String nazione, String provincia, String citta, String indirizzo, int userId) {
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


    //Costruttore creato senza user_id durante la creazione della Servlet, non sappiamo come gestire l'user id.
    public AnagraficaDTO(String nome, String cognome, String email, String dataDiNascita, String genere, String nazione, String provincia, String citta, String indirizzo, int userId) {
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


    //-------------------------------------------------------------------------------------------------------------
    //GETTERS AND SETTERS

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
    //TO STRING

    @Override
    public String toString() {
        return "AnagraficaDTO{" +
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
                ", userId='" + userId + '\'' +
                '}';
    }


    //--------------------------------------------------------------------------------------------------------------

}






