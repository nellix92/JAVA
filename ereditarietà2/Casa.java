package ereditarietà2;

public abstract class Casa {
	
	protected int superficie;
	protected int numeroStanze;
	

	
	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	public int getNumeroStanze() {
		return numeroStanze;
	}


	public void setNumeroStanze(int numeroStanze) {
		this.numeroStanze = numeroStanze;
	}


	public Casa(int superficie, int numeroStanze) {
		this.superficie = superficie;
		this.numeroStanze = numeroStanze;
	}


	public abstract int Costo();
}
