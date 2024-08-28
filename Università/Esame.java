package Università;

public class Esame {

	private int matricola;
	private String cognome;
	private String nome;
	private int voto;

	public Esame(int matricola, String cognome, String nome, int voto) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.voto = voto;
	}

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

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	

}
