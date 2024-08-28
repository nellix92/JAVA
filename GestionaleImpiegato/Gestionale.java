package GestionaleImpiegato;

import java.util.ArrayList;
import java.util.List;

public class Gestionale {

	private List<Impiegato> impiegati = new ArrayList<Impiegato>();
	private List<Dipartimento> dipartimenti = new ArrayList<Dipartimento>();
	private List<Progetto> progetti = new ArrayList<Progetto>();

	public void insertImpiegato(Impiegato i) {
		impiegati.add(i);
	}

	public void deleteImpiegato(String codFIscale) {
		for (Impiegato impiegato : impiegati) {
			if (impiegato.getCodiceFiscale().equals(codFIscale)) {
				impiegati.remove(impiegato);
				break;
			} 
		}

	}

	public void insertProgetto(Progetto p) {
		progetti.add(p);
	}

	public void associaImpiegatoProgetto(Progetto p,Impiegato i) {
		for (Progetto prog : progetti) {
			if (prog.getNome().equals(p.getNome())) {
				prog.getImpiegati().add(i);
				break;
			}
		}
	}

	public void insertDipartimento(Dipartimento d) {
		dipartimenti.add(d);
	}
	
	public void associaImpiegatoDipartimento (Dipartimento d, Impiegato i) {
		for (Dipartimento dipartimento : dipartimenti) {
			if(dipartimento.getNome().equals(d.getNome())) {
				dipartimento.getImpiegati().add(i);
				break;
			}
			
		}
	}
	
	

	@Override
	public String toString() {
		return "Gestionale [impiegati=" + impiegati + ", dipartimenti=" + dipartimenti + ", progetti=" + progetti + "]";
	}

	public static void main(String[] args) {
		Gestionale g = new Gestionale();
		
		Impiegato i = new Impiegato();
		i.setCodiceFiscale("123456");
		
		g.insertImpiegato(i);
		
		Progetto p = new Progetto("Microonde");
		g.insertProgetto(p);
		Impiegato imp = new Impiegato();
		imp.setCodiceFiscale("654987");
		g.associaImpiegatoProgetto(p,imp);
		
		
		Dipartimento d = new Dipartimento();
		d.setNome("Fisica");
		g.insertDipartimento(d);
		Impiegato imp2 = new Impiegato();
		imp2.setCodiceFiscale("456123");
		g.associaImpiegatoDipartimento(d, imp2);
		
		g.deleteImpiegato("123456");;
		
		System.out.println(g.toString());
		
		
		
		
	}
}
