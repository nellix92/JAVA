package libreriaPatternDAO;

public class LibroDTO {
	
	private String nome;
	private int isbn;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public LibroDTO(String nome, int isbn) {
		this.nome = nome;
		this.isbn = isbn;
	}
	public LibroDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Libro [nome=" + nome + ", isbn=" + isbn + "]";
	}
}
