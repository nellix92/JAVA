package it.contrader.dao;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Agenzia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenziaDAO {

    private final String QUERY_ALL = "SELECT * FROM agenzia";
    private final String QUERY_CREATE = "INSERT INTO agenzia (nome, descrizione, provincia, citta, indirizzo, admin_id) VALUES (?,?,?,?,?,?)";

    private final String QUERY_UPDATE = "UPDATE agenzia SET nome=?, descrizione=?, provincia=?, citta=?, indirizzo=? WHERE id=?";
    private final String QUERY_NAME = "SELECT * FROM agenzia WHERE nome=?";
    private final String QUERY_DELETE = "DELETE FROM agenzia WHERE id=?";
    private final String QUERY_READ = "SELECT * FROM agenzia WHERE id=?";
    private final String QUERY_FINDBYADMIN = "SELECT * FROM agenzia WHERE admin_id = ?";

    public boolean insert(Agenzia agenziaToInsert){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setString(1, agenziaToInsert.getNome());
            preparedStatement.setString(2, agenziaToInsert.getDescrizione());
            preparedStatement.setString(3, agenziaToInsert.getProvincia());
            preparedStatement.setString(4, agenziaToInsert.getCitta());
            preparedStatement.setString(5, agenziaToInsert.getIndirizzo());
            preparedStatement.setInt(6, agenziaToInsert.getAdmin_id());
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            System.out.println("Exception durante la query:\n" + QUERY_CREATE);
            e.printStackTrace();
            return false;
        }
    }

    public Agenzia read(int id){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int admin_id;
            String nome, descrizione, provincia, citta, indirizzo;

            admin_id = resultSet.getInt("admin_id");
            nome = resultSet.getString("nome");
            descrizione = resultSet.getString("descrizione");
            provincia = resultSet.getString("provincia");
            citta = resultSet.getString("citta");
            indirizzo = resultSet.getString("indirizzo");

            Agenzia agenzia = new Agenzia();
            agenzia.setNome(nome);
            agenzia.setDescrizione(descrizione);
            agenzia.setProvincia(provincia);
            agenzia.setCitta(citta);
            agenzia.setIndirizzo(indirizzo);
            agenzia.setAdmin_id(admin_id);
            agenzia.setId(resultSet.getInt("id"));

            return agenzia;
        }catch(SQLException e){
            System.out.println("Exception durante la query\n" + QUERY_READ);
            e.printStackTrace();
            return null;
        }
    }

    public Agenzia findByName(String nome){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id, admin_id;
            String descrizione, provincia, citta, indirizzo;

            id = resultSet.getInt("id");
            admin_id = resultSet.getInt("admin_id");
            descrizione = resultSet.getString("descrizione");
            provincia = resultSet.getString("provincia");
            citta = resultSet.getString("citta");
            indirizzo = resultSet.getString("indirizzo");

            Agenzia agenzia = new Agenzia();
            agenzia.setId(resultSet.getInt(id));
            agenzia.setDescrizione(descrizione);
            agenzia.setProvincia(provincia);
            agenzia.setCitta(citta);
            agenzia.setIndirizzo(indirizzo);
            agenzia.setAdmin_id(admin_id);
            agenzia.setNome(resultSet.getString("nome"));

            return agenzia;
        }catch(SQLException e){
            System.out.println("Exception durante la query\n" + QUERY_READ);
            e.printStackTrace();
            return null;
        }
    }

    public Agenzia findByFk(int fk){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FINDBYADMIN);
            preparedStatement.setInt(1, fk);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id, admin_id;
            String nome, descrizione, indirizzo, citta, provincia;

            id = resultSet.getInt("id");
            nome = resultSet.getString("nome");
            descrizione = resultSet.getString("descrizione");
            provincia = resultSet.getString("provincia");
            citta = resultSet.getString("citta");
            indirizzo = resultSet.getString("indirizzo");
            admin_id = resultSet.getInt("admin_id");

            Agenzia a = new Agenzia();
            a.setId(id);
            a.setNome(nome);
            a.setDescrizione(descrizione);
            a.setProvincia(provincia);
            a.setCitta(citta);
            a.setIndirizzo(indirizzo);
            a.setAdmin_id(admin_id);

            return a;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Agenzia> getAll() {
        List<Agenzia> agenziaList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            Agenzia agenzia;
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String descrizione = resultSet.getString("descrizione");
                String provincia = resultSet.getString("provincia");
                String citta = resultSet.getString("citta");
                String indirizzo = resultSet.getString("indirizzo");
                int admin_id = resultSet.getInt("admin_id");
                agenzia = new Agenzia(nome, descrizione, provincia, citta, indirizzo, admin_id);
                agenzia.setId(id);
                agenziaList.add(agenzia);
            }
        }catch(SQLException e){
            System.out.println("Exception durante la query" + QUERY_ALL);
            e.printStackTrace();
        }
        return agenziaList;
    }

    public boolean update(Agenzia agenziaToUpdate){
        Connection connection = ConnectionSingleton.getInstance();

        if(agenziaToUpdate.getId() == 0){
            System.out.println("Agenzia non presente nel database");
            return false;
        }

        Agenzia agenziaRead = read(agenziaToUpdate.getId());
        if(!agenziaRead.equals(agenziaToUpdate)){
            try{
                if(agenziaToUpdate.getNome() == null || agenziaToUpdate.getNome() == ""){
                    agenziaToUpdate.setNome(agenziaRead.getNome());
                }
                if(agenziaToUpdate.getDescrizione() == null || agenziaToUpdate.getDescrizione() == ""){
                    agenziaToUpdate.setDescrizione(agenziaRead.getDescrizione());
                }
                if(agenziaToUpdate.getProvincia() == null || agenziaToUpdate.getProvincia() == ""){
                    agenziaToUpdate.setProvincia(agenziaRead.getProvincia());
                }
                if(agenziaToUpdate.getCitta() == null || agenziaToUpdate.getCitta() == ""){
                    agenziaToUpdate.setCitta(agenziaRead.getCitta());
                }
                if(agenziaToUpdate.getIndirizzo() == null || agenziaToUpdate.getIndirizzo() == ""){
                    agenziaToUpdate.setIndirizzo(agenziaRead.getIndirizzo());
                }
                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(1, agenziaToUpdate.getNome());
                preparedStatement.setString(2, agenziaToUpdate.getDescrizione());
                preparedStatement.setString(3, agenziaToUpdate.getProvincia());
                preparedStatement.setString(4, agenziaToUpdate.getCitta());
                preparedStatement.setString(5, agenziaToUpdate.getIndirizzo());
                preparedStatement.setInt(6, agenziaToUpdate.getId());
                int a = preparedStatement.executeUpdate();
                return a > 0;
            }catch(SQLException e){
                System.out.println("Exception durante la query:\n" + QUERY_UPDATE);
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

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
