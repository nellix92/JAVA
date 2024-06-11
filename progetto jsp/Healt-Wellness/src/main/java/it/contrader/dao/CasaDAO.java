package it.contrader.dao;

import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Casa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CasaDAO implements DAO<Casa>{

    private final String QUERY_ALL = "SELECT * FROM casa";
    private final String QUERY_CREATE = "INSERT INTO casa (nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile, id_agenzia) VALUES (?,?,?,?,?,?,?,?,?)";

    private final String QUERY_UPDATE = "UPDATE casa SET nome=?, prezzo=?, indirizzo=?, metri_quadrati=?, costruita=?, dettagli=?, tipo=?, disponibile=? WHERE id=?";
    private final String QUERY_NAME = "SELECT * FROM casa WHERE nome=?";
    private final String QUERY_DELETE = "DELETE FROM casa WHERE id=?";
    private final String QUERY_READ = "SELECT * FROM casa WHERE id=?";
    private final String QUERY_FINDBYADMIN = "SELECT * FROM casa WHERE id_agenzia = ?";

    private final String QUERY_FILTRA_PREZZO = "SELECT * FROM casa WHERE prezzo <= ? ORDER BY prezzo ASC" ;
    private final String QUERY_FILTRA_METRI_QUADRATI = "SELECT * FROM casa WHERE CAST(metri_quadrati AS SIGNED) <= ? ORDER BY metri_quadrati ASC" ;
    private final String QUERY_FILTRA_TIPO = "SELECT * FROM casa WHERE tipo LIKE ? ";
    private final String QUERY_FILTRA_NOME = "SELECT * FROM casa WHERE nome LIKE ? ";
    private final String QUERY_FILTRA_COSTRUITA = "SELECT * FROM casa WHERE costruita >= ? ";

    public CasaDAO() {
    }

    public List<Casa> getAll(){
        List<Casa> casaList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            Casa casa;
            while(resultSet.next()){
                {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String indirizzo = resultSet.getString("indirizzo");
                    String metri_quadrati = resultSet.getString("metri_quadrati");
                    String costruita = resultSet.getString("costruita");
                    String dettagli = resultSet.getString("dettagli");
                    String tipo = resultSet.getString("tipo");
                    Double prezzo = resultSet.getDouble("prezzo");
                    boolean disponibile = resultSet.getBoolean("disponibile");
                    int id_agenzia = resultSet.getInt("id_agenzia");
                    casa = new Casa(id_agenzia, nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
                    casa.setId(id);
                    casaList.add(casa);
                }
            }
        }catch(SQLException e){
            System.out.println("Exception durante la query" + QUERY_ALL);
            e.printStackTrace();
        }
        return casaList;
    }

    public List<Casa> getFiltraNome(String nomeFiltro) {
        List<Casa> casaList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            String query = QUERY_FILTRA_NOME;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + nomeFiltro + "%");

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String indirizzo = resultSet.getString("indirizzo");
                    String metri_quadrati = resultSet.getString("metri_quadrati");
                    String costruita = resultSet.getString("costruita");
                    String dettagli = resultSet.getString("dettagli");
                    String tipo = resultSet.getString("tipo");
                    double prezzo = resultSet.getDouble("prezzo");
                    boolean disponibile = resultSet.getBoolean("disponibile");
                    int id_agenzia = resultSet.getInt("id_agenzia");

                    Casa casa = new Casa(id_agenzia ,nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
                    casa.setId(id);
                    casaList.add(casa);
                }
            }
        }catch(SQLException e){
            System.out.print("Exception durante la query " + QUERY_FILTRA_NOME);
            e.printStackTrace();
        }
        return casaList;
    }

    public List<Casa> getFiltraTipo(String tipoFiltro) {
        List<Casa> casaList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            String query = QUERY_FILTRA_TIPO;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + tipoFiltro + "%");

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String indirizzo = resultSet.getString("indirizzo");
                    String metri_quadrati = resultSet.getString("metri_quadrati");
                    String costruita = resultSet.getString("costruita");
                    String dettagli = resultSet.getString("dettagli");
                    String tipo = resultSet.getString("tipo");
                    double prezzo = resultSet.getDouble("prezzo");
                    boolean disponibile = resultSet.getBoolean("disponibile");
                    int id_agenzia = resultSet.getInt("id_agenzia");

                    Casa casa = new Casa(id_agenzia, nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
                    casa.setId(id);
                    casaList.add(casa);
                }
            }
        }catch(SQLException e){
            System.out.print("Exception durante la query " + QUERY_FILTRA_TIPO);
            e.printStackTrace();
        }
        return casaList;
    }

    public List<Casa> getFiltroCostruita(int minAnnoCostruzione) {
        List<Casa> caseInRange = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            String query = QUERY_FILTRA_COSTRUITA;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, minAnnoCostruzione);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String indirizzo = resultSet.getString("indirizzo");
                    String metri_quadrati = resultSet.getString("metri_quadrati");
                    String costruita = resultSet.getString("costruita");
                    String dettagli = resultSet.getString("dettagli");
                    String tipo = resultSet.getString("tipo");
                    double prezzo = resultSet.getDouble("prezzo");
                    boolean disponibile = resultSet.getBoolean("disponibile");
                    int id_agenzia = resultSet.getInt("id_agenzia");

                    Casa casa = new Casa(id_agenzia, nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
                    casa.setId(id);
                    caseInRange.add(casa);
                }
            }
        } catch (SQLException e) {
            System.out.println("Eccezione durante la query. " + QUERY_FILTRA_COSTRUITA);
            e.printStackTrace();
        }
        return caseInRange;
    }

    public List<Casa> getFilterPrezzo(double prezzoFiltro){
        List<Casa> caseInRange = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            String query = QUERY_FILTRA_PREZZO;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDouble(1, prezzoFiltro);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String indirizzo = resultSet.getString("indirizzo");
                    String metri_quadrati = resultSet.getString("metri_quadrati");
                    String costruita = resultSet.getString("costruita");
                    String dettagli = resultSet.getString("dettagli");
                    String tipo = resultSet.getString("tipo");
                    double prezzo = resultSet.getDouble("prezzo");
                    boolean disponibile = resultSet.getBoolean("disponibile");
                    int id_agenzia = resultSet.getInt("id_agenzia");

                    Casa casa = new Casa(id_agenzia, nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
                    casa.setId(id);
                    caseInRange.add(casa);
                }
            }
        } catch (SQLException e) {
            System.out.println("Eccezione durante la query. " + QUERY_FILTRA_PREZZO);
            e.printStackTrace();
        }
        return caseInRange;
    }

    public List<Casa> getFiltroMetri(int metri){
        List<Casa> caseInRange = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            String query = QUERY_FILTRA_METRI_QUADRATI;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, metri);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String indirizzo = resultSet.getString("indirizzo");
                    String metri_quadrati = resultSet.getString("metri_quadrati");
                    String costruita = resultSet.getString("costruita");
                    String dettagli = resultSet.getString("dettagli");
                    String tipo = resultSet.getString("tipo");
                    double prezzo = resultSet.getDouble("prezzo");
                    boolean disponibile = resultSet.getBoolean("disponibile");
                    int id_agenzia = resultSet.getInt("id_agenzia");

                    Casa casa = new Casa(id_agenzia, nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
                    casa.setId(id);
                    caseInRange.add(casa);
                }
            }
        } catch (SQLException e) {
            System.out.println("Eccezione durante la query. " + QUERY_FILTRA_METRI_QUADRATI);
            e.printStackTrace();
        }
        return caseInRange;
    }

    public Casa read(int id){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id_agenzia;
            String nome, indirizzo, metri_quadrati, costruita, dettagli, tipo;
            Double prezzo;

            id_agenzia = resultSet.getInt("id_agenzia");
            nome = resultSet.getString("nome");
            indirizzo = resultSet.getString("indirizzo");
            metri_quadrati = resultSet.getString("metri_quadrati");
            costruita = resultSet.getString("costruita");
            dettagli = resultSet.getString("dettagli");
            tipo = resultSet.getString("tipo");
            boolean disponibile = resultSet.getBoolean("disponibile");
            prezzo = resultSet.getDouble("prezzo");

            Casa casa = new Casa(id_agenzia, nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
            casa.setId(resultSet.getInt("id"));

            return casa;
        }catch(SQLException e){
            System.out.println("Exception durante la query\n" + QUERY_READ);
            e.printStackTrace();
            return null;
        }
    }

    public Casa getNome(String nomeCasa){
        Casa casa = new Casa();
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_NAME);
            preparedStatement.setString(1, nomeCasa);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int id_agenzia = resultSet.getInt("id_agenzia");
                String nome = resultSet.getString("nome");
                String indirizzo = resultSet.getString("indirizzo");
                String metri_quadrati = resultSet.getString("metri_quadrati");
                String costruita = resultSet.getString("costruita");
                String dettagli = resultSet.getString("dettagli");
                String tipo = resultSet.getString("tipo");
                boolean disponibile = resultSet.getBoolean("disponibile");
                Double prezzo = resultSet.getDouble("prezzo");

                casa = new Casa(id_agenzia, nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
                casa.setId(id);
            }
        }catch(SQLException e){
            System.out.println("Exception durante la query" + QUERY_NAME);
            e.printStackTrace();
            return null;
        }
        return casa;
    }

    public Casa findByFk(int fk){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FINDBYADMIN);
            preparedStatement.setInt(1, fk);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id, id_agenzia;
            String nome, indirizzo, metri_quadrati, costruita, dettagli, tipo;
            Double prezzo;
            boolean disponibile;

            id = resultSet.getInt("id");
            id_agenzia = resultSet.getInt("id_agenzia");
            nome = resultSet.getString("nome");
            indirizzo = resultSet.getString("indirizzo");
            metri_quadrati = resultSet.getString("metri_quadrati");
            costruita = resultSet.getString("costruita");
            dettagli = resultSet.getString("dettagli");
            tipo = resultSet.getString("tipo");
            prezzo = resultSet.getDouble("prezzo");
            disponibile = resultSet.getBoolean("disponibile");

            Casa casa = new Casa(id, id_agenzia, nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile);
            casa.setId_agenzia(resultSet.getInt("id_agenzia"));

            return casa;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(Casa casaToInsert){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setString(1, casaToInsert.getNome());
            preparedStatement.setDouble(2, casaToInsert.getPrezzo());
            preparedStatement.setString(3, casaToInsert.getIndirizzo());
            preparedStatement.setString(4, casaToInsert.getMetri_quadrati());
            preparedStatement.setString(5, casaToInsert.getCostruita());
            preparedStatement.setString(6, casaToInsert.getDettagli());
            preparedStatement.setString(7, casaToInsert.getTipo());
            preparedStatement.setBoolean(8, true);
            preparedStatement.setInt(9, casaToInsert.getId_agenzia());
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            System.out.println("Exception durante la query:\n" + QUERY_CREATE);
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Casa casaToUpdate){
        Connection connection = ConnectionSingleton.getInstance();

        if(casaToUpdate.getId() == 0){
            System.out.println("La casa che cerchi non è presente nel db");
            return false;
        }

        Casa casaRead = read(casaToUpdate.getId());
        if(!casaRead.equals(casaToUpdate)){
            try{
                if(casaToUpdate.getNome() == null || casaToUpdate.getNome().equals("")){
                    casaToUpdate.setNome(casaRead.getNome());
                }
                if(casaToUpdate.getPrezzo() == 0.0){
                    System.out.println("*************************" + casaRead.getPrezzo());
                    casaToUpdate.setPrezzo(casaRead.getPrezzo());
                }
                if(casaToUpdate.getIndirizzo() == null || casaToUpdate.getIndirizzo().equals("")){
                    casaToUpdate.setIndirizzo(casaRead.getIndirizzo());
                }
                if(casaToUpdate.getMetri_quadrati() == null || casaToUpdate.getMetri_quadrati().equals("")){
                    casaToUpdate.setMetri_quadrati(casaRead.getMetri_quadrati());
                }
                if(casaToUpdate.getCostruita() == null || casaToUpdate.getCostruita().equals("")){
                    casaToUpdate.setCostruita(casaRead.getCostruita());
                }
                if(casaToUpdate.getDettagli() == null || casaToUpdate.getDettagli().equals("")){
                    casaToUpdate.setDettagli(casaRead.getDettagli());
                }
                if(casaToUpdate.getTipo() == null || casaToUpdate.getTipo().equals("")){
                    casaToUpdate.setTipo(casaRead.getTipo());
                }

                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(1, casaToUpdate.getNome());
                preparedStatement.setDouble(2, casaToUpdate.getPrezzo());
                preparedStatement.setString(3, casaToUpdate.getIndirizzo());
                preparedStatement.setString(4, casaToUpdate.getMetri_quadrati());
                preparedStatement.setString(5, casaToUpdate.getCostruita());
                preparedStatement.setString(6, casaToUpdate.getDettagli());
                preparedStatement.setString(7, casaToUpdate.getTipo());
                preparedStatement.setBoolean(8, casaToUpdate.isDisponibile());
                preparedStatement.setInt(9, casaToUpdate.getId());
                System.out.println(casaToUpdate);
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
