package dao;

import model.Ruolo;

public interface RuoloDao {

	public void insert(Ruolo r);

	public Ruolo findById(int id);

	public boolean delete(Ruolo r);

	public boolean update(Ruolo r);

}
