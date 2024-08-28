package Biblioteca;

public class Libro {

	private String titolo;
	private String autore;
	private int prezzo;

	public Libro(String titolo, String autore, int prezzo) {
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}

	public int getPrezzo() {
		return prezzo;
	}

}
