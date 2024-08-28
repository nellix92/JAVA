package ereditarietà2;

public class Appartemento extends Casa {
	
	private int codEnergetico;

	public Appartemento(int superficie, int numeroStanze, int codEnergetico) {
		super(superficie, numeroStanze);
		this.codEnergetico = codEnergetico;
	}

	@Override
	public int Costo() {
	
		int costo = superficie * 1500 + numeroStanze * codEnergetico;
		return costo;
	}

}

