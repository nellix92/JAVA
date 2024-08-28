package ereditarietà4;

public class fileAudio extends File implements Riproducibile, RegolazioneVolume {

	private int volume;
	private int durata;

	public fileAudio(String titolo, int volume, int durata) {
		super(titolo);
		if (volume > 0)
			this.volume = volume;
		if (durata > 0)
			this.durata = durata;
	}

	public int getDurata() {
		return durata;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public void weaker() {
		if (volume > 0)
			volume--;
	}

	@Override
	public void louder() {
		if (volume < 100)
			volume++;
	}

	@Override
	public void play() {

		String titolo = super.getTitolo();
		String pEsclamativo = "";
		for (int i = 0; i < durata; i++) {
			titolo = titolo + super.getTitolo();
		}
		for (int i = 0; i < volume; i++) {
			pEsclamativo = pEsclamativo + "!";
		}
		System.out.println(titolo + pEsclamativo);
	}

	@Override
	public void setDurata(int durata) {
		if (durata > 0)
			this.durata = durata;
	}

}
