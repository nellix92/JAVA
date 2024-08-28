package Università;

import java.util.ArrayList;
import java.util.List;

public class Corso {
	
    private ArrayList<Esame>esami = new ArrayList<>();
    
	public Corso(ArrayList<Esame> esami) {
		super();
		this.esami = esami;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(ArrayList<Esame> esami) {
		this.esami = esami;
	}

	public int votoMinimo() {
		int min = 31;
		for (Esame esame : esami) {
			if(esame.getVoto()<min) {
				min = esame.getVoto();
			}
		}
		return min;
	}
	
	public List<String>cognomiPeggiori() {
		List<String>elenco = new ArrayList<String>();
		int votoMin = votoMinimo();
		for (Esame esame : esami) {
			if(esame.getVoto()==votoMin) {
				elenco.add(esame.getCognome());
			}
		}
		return elenco;
	}
	
	public static void main(String[] args) {
		Esame e = new Esame(1,"Rossi","Mario",25);
		Esame e1 = new Esame(2,"Ambrosio","Emanuele",18);
		Esame e2 = new Esame(3,"Lavato","Guido",29);
		ArrayList<Esame>esami=new ArrayList<Esame>();
		esami.add(e);
		esami.add(e1);
		esami.add(e2);
	
		Corso c = new Corso(esami);
		System.out.println("Il voto minimo è: "+c.votoMinimo());
		List<String>elenco = new ArrayList<String>();
		elenco = c.cognomiPeggiori();
		System.out.println("Le persone con voto peggiore sono: "+ elenco);
		System.out.println("Le persone con voto peggiore sono: ");
		for (String res : elenco) {
			System.out.println("- "+res);
		}
		
	}

}
