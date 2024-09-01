package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Impiegato;

public class ImpiegatoDaoImpl implements ImpiegatoDao {
	private List<Impiegato> impiegato = new ArrayList<>();

	public Impiegato findByCodiceFiscale(String codiceFiscale) {
		for (Impiegato impiegato2 : impiegato) {
			if (impiegato2.getCodiceFiscale().equals(codiceFiscale)) {
				return impiegato2;
			}
		}
		return null;

	}

	public void insert(Impiegato i) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "admin");

			String updateTableSQL = "INSERT INTO articolo(nome, cognome, codicefiscale, matricola) VALUES(?,?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, i.getNome());
			cmd.setString(2, i.getCognome());
			cmd.setString(3, i.getCodiceFiscale());
			cmd.setInt(4, i.getMatricola());

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}

	public boolean update(Impiegato i) {
		for (Impiegato impiegato2 : impiegato) {
			if (impiegato2.getCodiceFiscale().equals(i.getCodiceFiscale())) {
				impiegato2.setNome(i.getNome());
				impiegato2.setCognome(i.getNome());
				impiegato2.setMatricola(i.getMatricola());
				return true;
			}
		}
		return false;

	}

	public boolean delete(String codiceFiscale) {
		for (Impiegato impiegato2 : impiegato) {
			if (impiegato2.getCodiceFiscale().equals(codiceFiscale)) {
				impiegato.remove(impiegato2);
				return true;
			}
		}
		return false;
	}

}
