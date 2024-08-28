package ereditarietà2;

public class Villa extends Casa {

	private boolean pisicna;
	
	public Villa(int superficie, int numeroStanze, boolean pisicna) {
		super(superficie, numeroStanze);
		this.pisicna = pisicna;
	}


	@Override
	public int Costo() {

		int costo = superficie * 2000;
		if (pisicna && numeroStanze>=10) {
			costo = costo + 20000 + 10000;
		}
		if (pisicna && numeroStanze<10)  {
			costo = costo + 20000;
		}
		return costo;
	}
}
