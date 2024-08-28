package ereditarietà4;

public abstract class File {

	private String titolo;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public File(String titolo) {
		this.titolo = titolo;
	}
	
	
	
}
