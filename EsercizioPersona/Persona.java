package EsercizioPersona;

import java.util.Objects;

public class Persona {

	private String nome;
	private String cognome;
	private String indirizzo;
	private int numeroTelefono;
	
	public Persona() {
		
	}
	
	public Persona (String nome, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
	}

	public Persona(String nome, String cognome, String indirizzo, int numeroTelefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.numeroTelefono = numeroTelefono;
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(indirizzo, other.indirizzo)
				&& Objects.equals(nome, other.nome) && numeroTelefono == other.numeroTelefono;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + ", numeroTelefono="
				+ numeroTelefono + "]";
	}
	
	public static void main(String[] args) {
		Persona p = new Persona("Pippo","Baudo");
		Persona p1 = new Persona("Mario","Rossi");
		System.out.println(p);
		System.out.println(p.equals(p1));
		p.setNome("Mario");
		p.setCognome("Rossi");
		System.out.println(p.equals(p1));

	}

}
