package GestionaleImpiegato;

public class Impiegato {
	private String codiceFiscale;
	private String nome;
	private String cognome;

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
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

	@Override
	public String toString() {
		return "Impiegato [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	

}
