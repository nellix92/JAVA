package ereditarietà3;

public class Moto extends Veicolo {

	private int tempi;

	public int getTempi() {
		return tempi;
	}

	public void setTempi(int tempi) {
		this.tempi = tempi;
	}

	@Override
	public String toString() {
		return "Moto [tempi=" + tempi + "marca=" + super.getMarca() + ", anno=" + super.getAnno() + ", cilindrata=" + super.getCilindrata() +"]";
	}
	
	
}
