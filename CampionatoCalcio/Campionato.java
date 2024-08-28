package CampionatoCalcio;

import java.util.ArrayList;
import java.util.List;

public class Campionato {

	private String nome;
	private List<Squadra> squadre = new ArrayList<Squadra>();
	private List<Partita> partite = new ArrayList<Partita>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(List<Squadra> squadre) {
		this.squadre = squadre;
	}

	public List<Partita> getPartite() {
		return partite;
	}

	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}

	public void infoSquadra(Squadra squadra) {
		for (Partita partita : partite) {
			if (partita.getSquadraCasa().getNome().equals(squadra.getNome())) {
				System.out.println(
						squadra.getNome() + "-" + partita.getSquadraTrasferta().getNome() + ": giocata in casa");
			}
			if (partita.getSquadraTrasferta().getNome().equals(squadra.getNome())) {
				System.out.println(
						squadra.getNome() + "-" + partita.getSquadraCasa().getNome() + ": giocata in trasferta");
			}

		}
	}
	
	public static void main(String[] args) {
		Campionato c = new Campionato();
		c.setNome("2023-2024");
		
		Partita p = new Partita();
		
		Squadra s = new Squadra ();
		s.setNome("Napoli");
		Squadra s1 = new Squadra ();
		s1.setNome("Inter");
		
		p.setSquadraCasa(s);
		p.setSquadraTrasferta(s1);
		
		p.setGoalCasa(3);
		p.setGoalTrasferta(1);
		
		c.getPartite().add(p);
		c.infoSquadra(s);
//		Giocatore g1 = new Giocatore();
//		g1.setNome("Mario");
//		g1.setCapitano(true);
//		g1.setAnnoDiNascita(1992);
	}

}
