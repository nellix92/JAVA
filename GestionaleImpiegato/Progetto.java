package GestionaleImpiegato;

import java.util.ArrayList;
import java.util.List;

public class Progetto {
	private String nome;
	private int budget;
	private String sede;
	private List<Impiegato> impiegati = new ArrayList<Impiegato>();

	public Progetto (String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public List<Impiegato> getImpiegati() {
		return impiegati;
	}

	public void setImpiegati(List<Impiegato> impiegati) {
		this.impiegati = impiegati;
	}
	@Override
	public String toString() {
		return "Progetto [nome=" + nome + ", budget=" + budget + ", sede=" + sede + ", impiegati=" + impiegati + "]";
	}

	
}
