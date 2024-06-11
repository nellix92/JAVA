package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;


import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Anagrafica;


public class AnagraficaDAO implements DAO<Anagrafica> {

    private final String QUERY_ALL = "SELECT * FROM anagrafica";
    private final String QUERY_CREATE = "INSERT INTO anagrafica (nome, cognome, email,datadinascita,genere,nazione,provincia,citta,indirizzo,user_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String QUERY_READ = "SELECT * FROM anagrafica WHERE id=?";
    private final String QUERY_FIND_BY_USER = "SELECT * FROM anagrafica WHERE user_id=?";
    private final String QUERY_UPDATE = "UPDATE anagrafica SET nome=?, cognome=?, email=?,  datadinascita=?, genere=?, nazione=?, provincia=?, citta=?, indirizzo=? WHERE id=?";
    private final String QUERY_DELETE = "DELETE FROM anagrafica WHERE id=?";


    //--------------------------------------------------------------------------------------------------------------

    public AnagraficaDAO() {

    }

    //--------------------------------------------------------------------------------------------------------------

    public List<Anagrafica> getAll() {
        List<Anagrafica> anagraficasList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            Anagrafica anagrafica;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                String email = resultSet.getString("email");
                String dataDiNascita = resultSet.getString("datadinascita");
                String genere = resultSet.getString("genere");
                String nazione = resultSet.getString("nazione");
                String provincia = resultSet.getString("provincia");
                String citta = resultSet.getString("citta");
                String indirizzo = resultSet.getString("indirizzo");
                int userId = resultSet.getInt("user_id");

                anagrafica = new Anagrafica(nome, cognome, email,dataDiNascita,genere,nazione,provincia,citta,indirizzo,userId);
                anagrafica.setId(id);
                anagraficasList.add(anagrafica);
            }
        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_ALL);
            e.printStackTrace();
            return null;
        }
        return anagraficasList;
    }


    //--------------------------------------------------------------------------------------------------------------



    public boolean insert(Anagrafica anagraficaToInsert) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setString(1, anagraficaToInsert.getNome());
            preparedStatement.setString(2, anagraficaToInsert.getCognome());
            preparedStatement.setString(3, anagraficaToInsert.getEmail());
            preparedStatement.setString(4, anagraficaToInsert.getDataDiNascita());
            preparedStatement.setString(5, anagraficaToInsert.getGenere());
            preparedStatement.setString(6, anagraficaToInsert.getNazione());
            preparedStatement.setString(7, anagraficaToInsert.getProvincia());
            preparedStatement.setString(8, anagraficaToInsert.getCitta());
            preparedStatement.setString(9, anagraficaToInsert.getIndirizzo());
            preparedStatement.setInt(10, anagraficaToInsert.getUserId());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_CREATE);
            e.printStackTrace();
            return false;
        }
    }


    //--------------------------------------------------------------------------------------------------------------


    public Anagrafica read(int anagraficaId) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setInt(1, anagraficaId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String nome, cognome, email, genere, dataDiNascita, nazione, provincia, citta, indirizzo;
            int userId;
            nome = resultSet.getString("nome");
            cognome = resultSet.getString("cognome");
            email = resultSet.getString("email");
            genere = resultSet.getString("genere");
            dataDiNascita = resultSet.getString("datadinascita");
            nazione = resultSet.getString("nazione");
            provincia = resultSet.getString("provincia");
            citta = resultSet.getString("citta");
            indirizzo = resultSet.getString("indirizzo");
            userId = resultSet.getInt("user_id");

            Anagrafica anagrafica = new Anagrafica(nome, cognome, email, genere, dataDiNascita, nazione, provincia, citta, indirizzo, userId);
            anagrafica.setId(resultSet.getInt("id"));

            return anagrafica;
        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_READ);
            e.printStackTrace();
            return null;
        }
    }


    //------------------------------------------------------------------------------------------------------------------

    public Anagrafica readByUser(int userId) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND_BY_USER);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String cognome, nome, email, genere, dataDiNascita, nazione, provincia, citta, indirizzo;
            int idUser;

            cognome = resultSet.getString("cognome");
            nome = resultSet.getString("nome");
            email = resultSet.getString("email");
            genere = resultSet.getString("genere");
            dataDiNascita = resultSet.getString("datadinascita");
            nazione = resultSet.getString("nazione");
            provincia = resultSet.getString("provincia");
            citta = resultSet.getString("citta");
            indirizzo = resultSet.getString("indirizzo");
            idUser = resultSet.getInt("user_id");
            Anagrafica anagrafica = new Anagrafica(cognome, nome, email, genere, dataDiNascita, nazione, provincia, citta, indirizzo, idUser);
            anagrafica.setId(resultSet.getInt("id"));

            return anagrafica;
        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_FIND_BY_USER);
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------------------------------------------------------------------------------------------


    public boolean update(Anagrafica anagraficaToUpdate) {
        Connection connection = ConnectionSingleton.getInstance();

        // Check if id is present
        if (anagraficaToUpdate.getId() == 0)
            return false;

        Anagrafica anagraficaRead = read (anagraficaToUpdate.getId());
        if (!anagraficaRead.equals(anagraficaToUpdate)) {
            try {
                // Fill the userToUpdate object
                if (anagraficaToUpdate.getNome() == null || anagraficaToUpdate.getNome().equals("")) {
                    anagraficaToUpdate.setNome(anagraficaRead.getNome());
                }
                if (anagraficaToUpdate.getCognome() == null || anagraficaToUpdate.getCognome().equals("")) {
                    anagraficaToUpdate.setCognome (anagraficaRead.getCognome());
                }
                if (anagraficaToUpdate.getEmail() == null || anagraficaToUpdate.getEmail().equals("")) {
                    anagraficaToUpdate.setEmail(anagraficaRead.getEmail());
                }
                if (anagraficaToUpdate.getDataDiNascita() == null || anagraficaToUpdate.getDataDiNascita().equals("")) {
                    anagraficaToUpdate.setDataDiNascita(anagraficaRead.getDataDiNascita());
                }
                if (anagraficaToUpdate.getGenere() == null || anagraficaToUpdate.getGenere().equals("")) {
                    anagraficaToUpdate.setGenere(anagraficaRead.getGenere());
                }
                if (anagraficaToUpdate.getNazione() == null || anagraficaToUpdate.getNazione().equals("")) {
                    anagraficaToUpdate.setNazione(anagraficaRead.getNazione());
                }
                if (anagraficaToUpdate.getProvincia() == null || anagraficaToUpdate.getProvincia().equals("")) {
                    anagraficaToUpdate.setProvincia(anagraficaRead.getProvincia());
                }
                if (anagraficaToUpdate.getCitta() == null || anagraficaToUpdate.getCitta().equals("")) {
                    anagraficaToUpdate.setCitta(anagraficaRead.getCitta());
                }
                if (anagraficaToUpdate.getIndirizzo() == null || anagraficaToUpdate.getIndirizzo().equals("")) {
                    anagraficaToUpdate.setIndirizzo(anagraficaRead.getIndirizzo());
                }

                // Update the user
                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(1, anagraficaToUpdate.getCognome());
                preparedStatement.setString(2, anagraficaToUpdate.getNome());
                preparedStatement.setString(3, anagraficaToUpdate.getEmail());
                preparedStatement.setString(4, anagraficaToUpdate.getGenere());
                preparedStatement.setString(5, anagraficaToUpdate.getDataDiNascita());
                preparedStatement.setString(6, anagraficaToUpdate.getNazione());
                preparedStatement.setString(7, anagraficaToUpdate.getProvincia());
                preparedStatement.setString(8, anagraficaToUpdate.getCitta());
                preparedStatement.setString(9, anagraficaToUpdate.getIndirizzo());
                preparedStatement.setInt(10, anagraficaToUpdate.getUserId());




                int a = preparedStatement.executeUpdate();
                return a > 0;

            } catch (SQLException e) {
                System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_UPDATE);
                e.printStackTrace();
                return false;
            }
        }

        return false;

    }



    //--------------------------------------------------------------------------------------------------------------




    public boolean delete(int id) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);
            int n = preparedStatement.executeUpdate();
            if (n != 0)
                return true;

        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_DELETE);
            e.printStackTrace();
            return false;
        }
        return false;
    }


    //--------------------------------------------------------------------------------------------------------------

}
