package ereditarietà3;

public class Auto extends Veicolo {

	private int porte;
	private String alimentazione;
	
	public int getPorte() {
		return porte;
	}
	public void setPorte(int porte) {
		this.porte = porte;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}
	@Override
	public String toString() {
		return "Auto [porte=" + porte + ", alimentazione=" + alimentazione +", marca="+super.getMarca()+", anno=" + super.getAnno() + ", cilindrata=" + super.getCilindrata() + super.toString()+ "]";
	}
	
	
}
