package dao;

import java.util.ArrayList;
import java.util.List;

import model.Storico;

public class StoricoDaoImpl implements StoricoDao{

	List<Storico> storico = new ArrayList<>();

	public void insert(Storico s) {
		storico.add(s);
	}

	public Storico findById(int id) {
		for (Storico storico2 : storico) {
			if (storico2.getId() == id) {
				return storico2;
			}
		}
		return null;

	}

	public boolean delete(Storico s) {
		for (Storico storico2 : storico) {
			if (storico2.equals(s)) {
				storico.remove(storico2);
				return true;
			}
		}
		return false;
	}

	public boolean update(Storico s) {
		for (Storico storico2 : storico) {
			if (storico2.equals(s)) {
				storico2.setId(s.getId());
				storico2.setDataInizio(s.getDataInizio());
				storico2.setDataFine(s.getDataFine());
				storico2.setMatricola(s.getMatricola());

				return true;
			}
		}
		return false;
	}
}
