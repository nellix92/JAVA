package Impiegato;

public class Impiegato {
	
	private int matricola;
	private String cognome;
	private String nome;
	private int retribuzione;
	
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
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
	public int getRetribuzione() {
		return retribuzione;
	}
	public void setRetribuzione(int retribuzione) {
		this.retribuzione = retribuzione;
	}
	public Impiegato(int matricola, String cognome, String nome, int retribuzione) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.retribuzione = retribuzione;
	}
	
	

}
