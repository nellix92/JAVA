package it.contrader.dao;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import it.contrader.model.Acquisto;
import it.contrader.utils.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcquistoDAO implements DAO<Acquisto>{

    private final String QUERY_ALL = "SELECT * FROM acquisto";

    private final String QUERY_ALL_BY_ANAGRAFICA = "SELECT * FROM acquisto WHERE anagrafica_id=?";

    private final String QUERY_ALL_BY_AGENZIA = "SELECT * FROM acquisto WHERE agenzia_id=?";

    private final String QUERY_CREATE = "INSERT INTO acquisto (anagrafica_id, nome, prezzo, casa_id) VALUES (?,?,?,?)";

    private final String QUERY_READ = "SELECT * FROM acquisto WHERE id=?";

    private final String QUERY_UPDATE = "UPDATE utenti SET username=?, password=?, usertype=? WHERE id=?";

    private final String QUERY_DELETE = "DELETE FROM utenti WHERE id=?";

    //------------------------------------------------------------------------------------------------------------------

    public List<Acquisto> getAll(){
        List<Acquisto> acquistoList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            Acquisto acquisto;
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int anagrafica_id = resultSet.getInt("anagrafica_id");
                String nome = resultSet.getString("nome");
                Double prezzo = resultSet.getDouble("prezzo");
                int casa_id = resultSet.getInt("casa_id");

                acquisto = new Acquisto(anagrafica_id, nome, prezzo, casa_id);
                acquisto.setId(id);

                acquistoList.add(acquisto);
            }
        }catch(SQLException e) {
            System.out.println("Exception durante la query:\n" + QUERY_ALL);
            e.printStackTrace();
            return null;
        }
        return acquistoList;
    }

    //------------------------------------------------------------------------------------------------------------------

    public List<Acquisto> getByAnagrafica(int anagraficaId) {
        List<Acquisto> acquistoList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_BY_ANAGRAFICA);

            preparedStatement.setInt(1, anagraficaId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Acquisto a;
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int anagrafica_id = resultSet.getInt("anagrafica_id");
                String nome = resultSet.getString("nome");
                Double prezzo = resultSet.getDouble("prezzo");
                int casa_id = resultSet.getInt("casa_id");
                a = new Acquisto(anagrafica_id, nome, prezzo, casa_id);
                a.setId(id);
                acquistoList.add(a);
            }
        } catch (SQLException e) {
            System.out.println("ERRORE DURANTE LA QUERY" + QUERY_ALL_BY_ANAGRAFICA);
            e.printStackTrace();
            return null;
        }
        return acquistoList;
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean insert (Acquisto acquistoToInsert){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setInt(1, acquistoToInsert.getAnagrafica_id());
            preparedStatement.setString(2, acquistoToInsert.getNome_casa());
            preparedStatement.setDouble(3, acquistoToInsert.getPrezzo());
            preparedStatement.setInt(4, acquistoToInsert.getCasa_id());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_CREATE);
            e.printStackTrace();
            return false;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public Acquisto read(int acquistoId){
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setInt(1, acquistoId);
            ResultSet resultSet = preparedStatement.executeQuery();
            int anagrafica_id, casa_id;
            String nome_casa;
            double prezzo;

            anagrafica_id = resultSet.getInt("anagrafica_id");
            nome_casa = resultSet.getString("nome");
            prezzo = resultSet.getDouble("prezzo");
            casa_id = resultSet.getInt("casa_id");
            Acquisto a = new Acquisto(anagrafica_id, nome_casa, prezzo, casa_id);
            a.setId(resultSet.getInt("id"));

            return a;

        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_READ);
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean update(Acquisto acquistoToUpdate){
        Connection connection = ConnectionSingleton.getInstance();
        if (acquistoToUpdate.getId() == 0){
            return false;
        }
        Acquisto acquistoRead = read(acquistoToUpdate.getId());
        if (!acquistoRead.equals(acquistoToUpdate)){
            try {
                if (acquistoToUpdate.getNome_casa() == null || acquistoToUpdate.getNome_casa().equals("")) {
                    acquistoToUpdate.setNome_casa(acquistoRead.getNome_casa());
                }
                if (acquistoToUpdate.getPrezzo() == 0.0) {
                    acquistoToUpdate.setPrezzo(acquistoRead.getPrezzo());
                }

                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(1, acquistoToUpdate.getNome_casa());
                preparedStatement.setDouble(2, acquistoToUpdate.getPrezzo());
                preparedStatement.setInt(3, acquistoToUpdate.getAnagrafica_id());
                preparedStatement.setInt(4, acquistoToUpdate.getCasa_id());
                preparedStatement.setInt(5, acquistoToUpdate.getId());
                int a = preparedStatement.executeUpdate();
                return a > 0;

            } catch (Exception e) {
                System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_UPDATE);
                e.printStackTrace();
                return false;            }
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean delete(int id){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);
            int n = preparedStatement.executeUpdate();
            if (n != 0){
                return true;
            }
        }catch(SQLException e){
            System.out.println("Exception durante la query:\n" + QUERY_DELETE);
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
