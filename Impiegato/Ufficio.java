package Impiegato;

public class Ufficio {

	private Impiegato[] impiegati;

	public Impiegato[] getImpiegati() {
		return impiegati;
	}

	public void setImpiegati(Impiegato[] impiegati) {
		this.impiegati = impiegati;
	}

	public Ufficio(Impiegato[] impiegati) {
		super();
		this.impiegati = impiegati;
	}

	public int calcolaMedia(int[] m) {
		// for per scorrere list impiegato for per vedere se l'impiegato è contenuto in
		// m allora aggiorna media
		int somma = 0;
		int count = 0;
		for (Impiegato impiegato : impiegati) {
			for (int impiegato2 : m) {
				if (impiegato.getMatricola() == impiegato2) {
					somma = somma + impiegato.getRetribuzione();
					count++;
				}
			}
		}
		int media = somma / count;
		return media;
	}

	public String[] RetribuzioneMedia(int[] a) {

		int media = calcolaMedia(a);
		String[] cognome = new String[this.impiegati.length];
		int posImp = 0;
		for (Impiegato impiegato : impiegati) {
			if (impiegato.getRetribuzione() > media) {
				cognome[posImp] = impiegato.getCognome();
				posImp++;
			}
		}
		return cognome;
	}

	public static void main(String[] args) {
		Impiegato r = new Impiegato(1, "Rossi", "Mario", 15000);
		Impiegato r1 = new Impiegato(2, "Gio", "Mario", 25000);
		Impiegato r2 = new Impiegato(3, "Mor", "Mario", 35000);
		Impiegato r3 = new Impiegato(4, "Ia", "Mario", 45000);

		Impiegato[] i = new Impiegato[4];
		i[0] = r;
		i[1] = r1;
		i[2] = r2;
		i[3] = r3;

		Ufficio u = new Ufficio(i);
		int[] m = new int[4];
		m[0] = 2;
		m[1] = 3;
		m[2] = 4;
		m[3] = 1;

		//System.out.println(u.calcolaMedia(m));
		String [] risultato =u.RetribuzioneMedia(m);
		for (String s : risultato) {
			if(s!=null)
			System.out.println(s);
		}
	}

}
