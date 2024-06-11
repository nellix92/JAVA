package it.contrader.model;

public class Anagrafica {

    private int id;
    private String cognome;
    private String nome;
    private String email;
    private String genere;
    private String dataDiNascita;
    private String nazione;
    private String provincia;
    private String citta;
    private String indirizzo;
    private int idUser;

    public Anagrafica(
            String cognome,
            String nome,
            String email,
            String genere,
            String dataDiNascita,
            String nazione,
            String provincia,
            String citta,
            String indirizzo,
            int idUser)
     {
        this.cognome = cognome;
        this.nome = nome;
        this.email=email;
        this.genere = genere;
        this.dataDiNascita = dataDiNascita;
        this.nazione = nazione;
        this.provincia = provincia;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.idUser = idUser;
    }

    public Anagrafica(
            int id,
            String cognome,
            String nome,
            String email,
            String genere,
            String dataDiNascita,
            String nazione,
            String provincia,
            String citta,
            String indirizzo,
            int idUser
    ) {
        this.id = id;
        this.cognome = cognome;
        this.nome = nome;
        this.email=email;
        this.genere = genere;
        this.dataDiNascita = dataDiNascita;
        this.nazione = nazione;
        this.provincia = provincia;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {this.email = email;}

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

    public int getIdUser() { return idUser; }

    public void setIdUser(int idUser) { this.idUser = idUser; }

    @Override
    public String toString() {
        return "Anagrafica{" +
                "id=" + id +
                ", cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita='" + dataDiNascita + '\'' +
                ", genere='" + genere + '\'' +
                ", nazione='" + nazione + '\'' +
                ", provincia='" + provincia + '\'' +
                ", citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", idUser=" + idUser +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (this == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Anagrafica other = (Anagrafica) obj;
        if (id != other.id)
            return false;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if(email == null){
            if(other.email !=null)
                return false;
        }
        if (dataDiNascita == null) {
            if (other.dataDiNascita != null)
                return false;
        } else if (!dataDiNascita.equals(other.dataDiNascita))
            return false;
        if (genere == null) {
            if (other.genere != null)
                return false;
        } else if (!genere.equals(other.genere))
            return false;
        if (nazione == null) {
            if (other.nazione != null)
                return false;
        } else if (!nazione.equals(other.nazione))
            return false;
        if (provincia == null) {
            if (other.provincia != null)
                return false;
        } else if (!provincia.equals(other.provincia))
            return false;
        if (citta == null) {
            if (other.citta != null)
                return false;
        } else if (!citta.equals(other.citta))
            return false;
        if (indirizzo == null) {
            if (other.indirizzo != null)
                return false;
        } else if (!indirizzo.equals(other.indirizzo))
            return false;
        if (idUser != other.idUser)
            return false;
        return true;
    }

}
