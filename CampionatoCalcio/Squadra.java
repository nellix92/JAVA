package CampionatoCalcio;

import java.util.List;

public class Squadra {

	private String nome;
	private List<Giocatore> giocatori;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

}
