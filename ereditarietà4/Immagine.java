package ereditarietà4;

public class Immagine extends File implements RegolazioneLuminosita {

	private int luminosita = 0;

	public Immagine(String titolo, int luminosita) {
		super(titolo);
		if (luminosita > 0)
			this.luminosita = luminosita;
	}

	@Override
	public void brighter() {
		if (luminosita < 100) {
			luminosita++;
		} else {
			System.out.println("Hai raggiunto il valore massimo della luminosità");
		}
	}

	@Override
	public void darker() {
		if (luminosita > 0) {
			luminosita--;
		} else {
			System.out.println("Hai raggiunto il valore minimo della luminosità");
		}
	}

	public void show() {

		String res = super.getTitolo();
		String ast = "";
		for (int i = 0; i < luminosita; i++) {
			ast = ast + "*";
		}
		System.out.println(res + ast);
	}
}
