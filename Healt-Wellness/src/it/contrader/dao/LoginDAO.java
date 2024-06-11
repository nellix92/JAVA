package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LoginDAO {

	private final String QUERY_LOGIN = "SELECT * FROM utenti WHERE username = ? AND password = ?";

	
	public User login (String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			
			statement.setString(1, username);
			statement.setString(2, password);

			User user = null;
			
			ResultSet resultSet;
			
			if(statement.executeQuery().next()) {
				resultSet = statement.executeQuery();
				resultSet.next();
				user = new User(resultSet.getInt("id"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("user_role"));
			}

			return user;
		}
		
		catch (SQLException e) {
			System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_LOGIN);
			e.printStackTrace();
			return null;
		}
	}
}
