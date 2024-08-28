package ereditarietà3;

public class Furgone extends Veicolo {

	private int capacita;

	public int getCapacita() {
		return capacita;
	}

	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}

	@Override
	public String toString() {
		return "Furgone [capacita=" + capacita + "marca=" + super.getMarca() + ", anno=" + super.getAnno() + ", cilindrata=" + super.getCilindrata() +"]";
	}
	
	
}
