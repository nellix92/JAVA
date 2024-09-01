package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Articolo;

public class ArticoloDao {

	public void insert(Articolo a) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "admin");

			String updateTableSQL = "INSERT INTO articolo(descrizione, quantita) VALUES(?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, a.getDescrizione());
			cmd.setInt(2, a.getQuantita());

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

	public void update(Articolo a) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "admin");

			String updateTableSQL = "UPDATE articolo(descrizione, quantita) VALUES(?,?) WHERE codice = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, a.getDescrizione());
			cmd.setInt(2, a.getQuantita());
			cmd.setInt(3, a.getCodice());

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

	public void delete(int codice) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "admin");

			String updateTableSQL = "DELETE from articolo WHERE codice = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, codice);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getByCodice(int codice) {

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection dbConnection = DriverManager.getConnection(url, "root", "admin");

			String query = "SELECT * FROM articolo WHERE codice = ?";

			PreparedStatement cmd = dbConnection.prepareStatement(query);

			cmd.setInt(1, codice);

			ResultSet res = cmd.executeQuery();
			
			System.out.println("Record is updated to DBUSER table!");

			boolean esiste = res.next();

			int cod = res.getInt(codice);
			System.out.println(cod);
			System.out.println(res.getString("descrizione"));
			System.out.println(res.getInt("quantita"));

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List<Articolo> getAll() {

		List<Articolo> articoli = new ArrayList<>();
		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection dbConnection = DriverManager.getConnection(url, "root", "admin");

			String query = "SELECT * FROM articolo";

			PreparedStatement cmd = dbConnection.prepareStatement(query);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			while (esiste) {
				Articolo a = new Articolo();
				int cod;
				cod = res.getInt("codice");
				System.out.println(cod);
				System.out.println(res.getString("descrizione"));
				System.out.println(res.getInt("quantita"));
				a.setCodice(cod);
				a.setDescrizione(res.getString("descrizione"));
				a.setQuantita(res.getInt("quantita"));
				articoli.add(a);
				esiste = res.next();// se esiste vado al valore successivo
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return articoli;
	}
}
