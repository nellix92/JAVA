package ereditarietà4;

import java.util.Scanner;

public class LettoreMultimediale {
	private Scanner s = new Scanner(System.in);
	private File[] elementi = new File[5];
	private int indice;
	private int scelta;

	public File[] getElementi() {
		return elementi;
	}

	public void setElementi(File[] elementi) {
		this.elementi = elementi;
	}

	public void insert() {
		System.out.println("Inserisci 5 elementi multimediali");
		for (int i = 0; i < elementi.length; i++) {
			System.out.println("Inserisci il tipo dell'elemeneto: 1-Immagine, 2-Audio, -3 Video ");
			int tipo = s.nextInt();
			s.nextLine();
			System.out.println("Inserisci il titolo:");
			String titolo = s.nextLine();
			switch (tipo) {
			case 1:
				System.out.println("Inserisci la luminosità:");
				int luminositaImmagine = s.nextInt();
				elementi[i] = new Immagine(titolo, luminositaImmagine);
				break;
			case 2:
				System.out.println("Inserisci la durata:");
				int durataAudio = s.nextInt();
				System.out.println("Inserisci il volume:");
				int volumeAudio = s.nextInt();
				elementi[i] = new fileAudio(titolo, volumeAudio, durataAudio);
				break;
			case 3:
				System.out.println("Inserisci la luminosita:");
				int luminositaVideo = s.nextInt();
				System.out.println("Inserisci la durata:");
				int durataVideo = s.nextInt();
				System.out.println("Inserisci il volume:");
				int volumeVideo = s.nextInt();
				elementi[i] = new Filmato(titolo, volumeVideo, luminositaVideo, durataVideo);
				break;
			}
		}
	}

	public void eseguiElemento() {
		System.out.println("Digita un numero da 1 a 5 per visualizzare l'elemento multimediale 0 per uscire");
		indice = s.nextInt();
		File elemento = elementi[indice - 1];
		if (elemento instanceof Immagine) {
			Immagine e = (Immagine) elemento;
			e.show();
		}
		if (elemento instanceof fileAudio) {
			fileAudio a = (fileAudio) elemento;
			a.play();
		}
		if (elemento instanceof Filmato) {
			Filmato f = (Filmato) elemento;
			f.play();
		}
	}

	public void regolaParametri(int indice) {
		File elemento = elementi[indice];
		if (elemento instanceof RegolazioneVolume) {
			System.out.println(
					"Premere 1 se si vuole aumentare il volume o 2 se si vuole diminuire il volume 0 per uscire");
			scelta = s.nextInt();
			if (scelta == 1) {
				((RegolazioneVolume) elemento).louder();
			} else if (scelta == 2) {
				((RegolazioneVolume) elemento).weaker();
			}
		}
		if (elemento instanceof RegolazioneLuminosita) {
			System.out.println(
					"Premere 1 se si vuole aumentare la luminosità o 2 se si vuole diminuire la luminosità o 0 per uscire");
			scelta = s.nextInt();
			if (scelta == 1) {
				((RegolazioneLuminosita) elemento).brighter();
			} else if (scelta == 2) {
				((RegolazioneLuminosita) elemento).darker();
			}
		}

	}

	public void Esegui() {
		insert();
		do {
			eseguiElemento();
			regolaParametri(indice - 1);
		} while (scelta != 0);
		System.out.println("Programma terminato");
	}
	
	public static void main(String[] args) {
		LettoreMultimediale l = new LettoreMultimediale();
		l.Esegui();
	}
}
