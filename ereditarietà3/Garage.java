package ereditarietà3;

public class Garage {

	private Veicolo[] veicoli = new Veicolo[15];

	public Veicolo[] getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(Auto[] veicoli) {
		this.veicoli = veicoli;
	}

	public boolean insertVeicolo(Veicolo v) {
		for (int i = 0; i < veicoli.length; i++) {
			if (veicoli[i] == null) {
				veicoli[i] = v;
				return true;
			}
		}
		return true;
	}

	public Veicolo deleteBYIndex(int index) {
		Veicolo v = veicoli[index];
		veicoli[index] = null;
		return v;
	}

	public void stampaVeicolo() {
		for (Veicolo veicolo : veicoli) {
			if (veicolo != null) {
				System.out.println(veicolo);
			}
		}
	}

	public static void main(String[] args) {
		Garage g = new Garage();
		Auto a = new Auto();
		a.setAlimentazione("benzina");
		a.setAnno(2010);
		a.setCilindrata(1200);
		a.setPorte(5);
		a.setMarca("BMW");
		g.insertVeicolo(a);
		g.stampaVeicolo();
		g.deleteBYIndex(0);
		System.out.println("veicoli nel garage");
		g.stampaVeicolo();
	}
}