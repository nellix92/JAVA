package dao;

import java.sql.SQLException;

import model.Impiegato;

public interface ImpiegatoDao {

	public Impiegato findByCodiceFiscale(String codiceFiscale) ;
	public void insert(Impiegato i) throws SQLException;
	public boolean update(Impiegato i);
	public boolean delete(String codiceFiscale);
}
