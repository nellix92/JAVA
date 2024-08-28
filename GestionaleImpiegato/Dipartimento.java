package GestionaleImpiegato;

import java.util.ArrayList;
import java.util.List;

public class Dipartimento {
	private String nome;
	private int numeroTelefono;
	private Citta citta;
	private Impiegato impiegato;
	private List<Impiegato> impiegati = new ArrayList<Impiegato>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	public Impiegato getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	public List<Impiegato> getImpiegati() {
		return impiegati;
	}

	public void setImpiegati(List<Impiegato> impiegati) {
		this.impiegati = impiegati;
	}

	@Override
	public String toString() {
		return "Dipartimento [nome=" + nome + ", numeroTelefono=" + numeroTelefono + ", citta=" + citta + ", impiegato="
				+ impiegato + ", impiegati=" + impiegati + "]";
	}
	
	

}
