package dao;

import model.Storico;

public interface StoricoDao {

	public void insert(Storico s);

	public Storico findById(int id);

	public boolean delete(Storico s);

	public boolean update(Storico s);
}
