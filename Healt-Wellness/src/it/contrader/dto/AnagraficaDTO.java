package it.contrader.dto;


public class AnagraficaDTO {

        private int id;
        private String cognome;
        private String nome;
        private String email;
        private String dataDiNascita;
        private String genere;
        private String nazione;
        private String provincia;
        private String citta;
        private String indirizzo;
        private int idUser;

        public AnagraficaDTO(
                String cognome,
                String nome,
                String email,
                String dataDiNascita,
                String genere,
                String nazione,
                String provincia,
                String citta,
                String indirizzo,
                int idUser
        ) {
                this.cognome = cognome;
                this.nome = nome;
                this.email = email;
                this.dataDiNascita = dataDiNascita;
                this.genere = genere;
                this.nazione = nazione;
                this.provincia = provincia;
                this.citta = citta;
                this.indirizzo = indirizzo;
                this.idUser = idUser;
        }

        public AnagraficaDTO(
                int id,
                String cognome,
                String nome,
                String email,
                String dataDiNascita,
                String genere,
                String nazione,
                String provincia,
                String citta,
                String indirizzo,
                int idUser
        ) {
                this.id = id;
                this.cognome = cognome;
                this.nome = nome;
                this.email = email;
                this.dataDiNascita = dataDiNascita;
                this.genere = genere;
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

        public int getIdUser() { return idUser; }

        public void setIdUser(int idUser) { this.idUser = idUser; }

        @Override
        public String toString() {
                return cognome + '\t' + nome + '\t' + email + '\t' + dataDiNascita + '\t' + genere + '\t' + nazione + '\t' + provincia + '\t' + citta + '\t' + indirizzo;
        }

}


