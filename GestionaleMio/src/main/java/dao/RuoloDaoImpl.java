package dao;

import java.util.ArrayList;
import java.util.List;

import model.Ruolo;

public class RuoloDaoImpl implements RuoloDao {

	List<Ruolo> ruoli = new ArrayList<>();

	public void insert(Ruolo r) {
		ruoli.add(r);
	}

	public Ruolo findById(int id) {
		for (Ruolo ruolo : ruoli) {
			if (ruolo.getId() == id) {
				return ruolo;
			}
		}
		return null;

	}

	public boolean delete(Ruolo r) {
		for (Ruolo ruolo : ruoli) {
			if (ruolo.equals(r)) {
				ruoli.remove(ruolo);
				return true;
			}
		}
		return false;
	}

	public boolean update(Ruolo r) {
		for (Ruolo ruolo : ruoli) {
			if (ruolo.equals(r)) {
				ruolo.setDescrizione(r.getDescrizione());
				ruolo.setId(r.getId());
				return true;
			}
		}
		return false;

	}
}
