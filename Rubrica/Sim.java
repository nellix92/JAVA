package Rubrica;


public class Sim {

	private int numero;
	private int importo;
	private Telefonata[] telefonateFatte = new Telefonata[10];
	private Telefonata[] telefonateRicevute = new Telefonata[10];

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public Telefonata[] getTelefonateFatte() {
		return telefonateFatte;
	}

	public void setTelefonateFatte(Telefonata[] telefonateFatte) {
		this.telefonateFatte = telefonateFatte;
	}

	public Telefonata[] getTelefonateRicevute() {
		return telefonateRicevute;
	}

	public void setTelefonateRicevute(Telefonata[] telefonateRicevute) {
		this.telefonateRicevute = telefonateRicevute;
	}

	public void insertTelefonataFatta(Telefonata t) {
		for (int i = telefonateFatte.length-2; i>=0; i--) {
			telefonateFatte[i+1] = telefonateFatte[i];
		}
		telefonateFatte[0] = t;
	}

	public void insertTelefonataRicevuta(Telefonata t) {
		for (int i = telefonateRicevute.length - 2; i >=0; i--) {
			telefonateRicevute[i + 1] = telefonateRicevute[i];
		}
		telefonateRicevute[0] = t;
	}

	public void stampaTelefonateFatte() {

		for (int i = 0; i < telefonateFatte.length; i++) {
			if (telefonateFatte[i] != null) {
				System.out.println(telefonateFatte[i].getNumero());
			}
		}

	}

	public static void main(String[] args) {

		Sim s = new Sim();
		for (int i = 0; i < 11; i++) {
			Telefonata t = new Telefonata();
			t.setCosto(i);
			t.setDurata(i);
			t.setNumero(i);
			s.insertTelefonataFatta(t);
			
		}
		

		s.stampaTelefonateFatte();
	}

}
