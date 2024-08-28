package ereditarietà4;

public class Filmato extends File implements RegolazioneVolume, RegolazioneLuminosita, Riproducibile {

	private int volume;
	private int luminosita;
	private int durata;

	public int getDurata() {
		return durata;
	}

	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getLuminosita() {
		return luminosita;
	}

	public Filmato(String titolo, int volume, int luminosita, int durata) {
		super(titolo);
		if (luminosita > 0)
			this.luminosita = luminosita;
		if (volume > 0)
			this.volume = volume;
		if (durata > 0)
			this.durata = durata;
	}

	@Override
	public void weaker() {
		if (volume > 0) {
			volume--;
		} else {
			System.out.println("Hai raggiunto il volume minimo consentito");
		}
	}

	@Override
	public void louder() {
		if (volume < 100) {
			volume++;
		} else {
			System.out.println("Hai raggiunto il volume massimo");
		}
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

	@Override
	public void play() {
		String titolo = super.getTitolo();
		String pEsclamativo = "";
		String ast = "";
		for (int i = 0; i < durata; i++) {
			titolo = titolo + super.getTitolo();
		}
		for (int i = 0; i < volume; i++) {
			pEsclamativo = pEsclamativo + "!";
		}
		for (int i = 0; i < luminosita; i++) {
			ast = ast + "*";
		}
		System.out.println(titolo+pEsclamativo+ast);
	}

	@Override
	public void setDurata(int durata) {
		if (durata > 0)
			this.durata = durata;
	}
}
