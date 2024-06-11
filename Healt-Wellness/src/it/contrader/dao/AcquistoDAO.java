package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.main.UserSingleton;
import it.contrader.model.Acquisto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcquistoDAO {

    private final String QUERY_ALL = "SELECT * FROM acquisto";

    private final String QUERY_ALL_BY_USER = "SELECT * FROM acquisto WHERE user_id=?";

    private final String QUERY_ALL_BY_AGENZIA = "SELECT * FROM acquisto WHERE agenzia_id=?";

    private final String QUERY_CREATE = "INSERT INTO acquisto (user_id, nome, prezzo, agenzia_id) VALUES (?,?,?,?)";

    private final String QUERY_READ = "SELECT * FROM acquisto WHERE id=?";

    public List<Acquisto> getAll(){
        List<Acquisto> acquistoList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            Acquisto acquisto;
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String nome = resultSet.getString("nome");
                Double prezzo = resultSet.getDouble("prezzo");
                int casa_id = resultSet.getInt("agenzia_id");

                acquisto = new Acquisto(user_id, nome, prezzo, casa_id);
                acquisto.setId(id);

                acquistoList.add(acquisto);
            }
        }catch(SQLException e){
            System.out.println("Exception durante la query " + QUERY_ALL);
            e.printStackTrace();
        }
        return acquistoList;
    }

    public List<Acquisto> getByUser(int userId) {
        List<Acquisto> acquistoList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_BY_USER);

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Acquisto a;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String nome = resultSet.getString("nome");
                Double prezzo = resultSet.getDouble("prezzo");
                int casa_id = resultSet.getInt("agenzia_id");
                a = new Acquisto(user_id, nome, prezzo, casa_id);
                a.setId(id);
                acquistoList.add(a);
            }
        } catch (SQLException e) {
            System.out.println("ERRORE DURANTE LA QUERY" + QUERY_ALL_BY_USER);
            e.printStackTrace();
            return null;
        }
        return acquistoList;
    }

    public List<Acquisto> getAllAgenzia(int idAgenzia){
        List<Acquisto> acquistoList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_BY_AGENZIA);
            preparedStatement.setInt(1, idAgenzia);
            ResultSet resultSet = preparedStatement.executeQuery();
            Acquisto a;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String nome = resultSet.getString("nome");
                Double prezzo = resultSet.getDouble("prezzo");
                int casa_id = resultSet.getInt("agenzia_id");
                a = new Acquisto(user_id, nome, prezzo, casa_id);
                a.setId(id);
                acquistoList.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_ALL_BY_AGENZIA);
            e.printStackTrace();
            return null;
        }
        return acquistoList;
    }


    public boolean insert(Acquisto acquistoToInsert){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setInt(1, acquistoToInsert.getUser_id());
            preparedStatement.setString(2, acquistoToInsert.getNome());
            preparedStatement.setDouble(3, acquistoToInsert.getPrezzo());
            preparedStatement.setInt(4, acquistoToInsert.getCasa_id());
            preparedStatement.execute();
            return true;
        }catch(SQLException e){
            System.out.println("Exception durante la query" + QUERY_CREATE);
            e.printStackTrace();
            return false;
        }
    }

    public Acquisto read(int id){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int user_id, casa_id;
            String nome;
            Double prezzo;

            user_id = resultSet.getInt("user_id");
            casa_id = resultSet.getInt("agenzia_id");
            nome = resultSet.getString("nome");
            prezzo = resultSet.getDouble("prezzo");

            Acquisto a = new Acquisto(user_id, nome, prezzo, casa_id);
            a.setId(resultSet.getInt("id"));

            return a;
        }catch(SQLException e){
            System.out.println("Exception durante la query" + QUERY_READ);
            e.printStackTrace();
            return null;
        }
    }
}
