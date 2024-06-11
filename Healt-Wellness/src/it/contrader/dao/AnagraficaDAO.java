package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Anagrafica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagraficaDAO {

    private final String QUERY_CREATE = "INSERT INTO anagrafica (cognome, nome, email, genere, datadinascita, nazione, provincia, citta, indirizzo, user_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String QUERY_READ = "SELECT * FROM anagrafica WHERE user_id=?";
    private final String QUERY_UPDATE = "UPDATE anagrafica SET cognome=?, nome=?, email=?, genere=?, datadinascita=?, nazione=?, provincia=?, citta=?, indirizzo=? WHERE user_id=?";

    public boolean insert(Anagrafica anagraficaToInsert) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setString(1, anagraficaToInsert.getCognome());
            preparedStatement.setString(2, anagraficaToInsert.getNome());
            preparedStatement.setString(3, anagraficaToInsert.getEmail());
            preparedStatement.setString(4, anagraficaToInsert.getGenere());
            preparedStatement.setString(5, anagraficaToInsert.getDataDiNascita());
            preparedStatement.setString(6, anagraficaToInsert.getNazione());
            preparedStatement.setString(7, anagraficaToInsert.getProvincia());
            preparedStatement.setString(8, anagraficaToInsert.getCitta());
            preparedStatement.setString(9, anagraficaToInsert.getIndirizzo());
            preparedStatement.setInt(10, anagraficaToInsert.getIdUser());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_CREATE);
            e.printStackTrace();
            return false;
        }
    }

    public Anagrafica read(int anagraficaId) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setInt(1, anagraficaId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String cognome, nome, email, genere, dataDiNascita, nazione, provincia, citta, indirizzo;
            int idUser;

            cognome = resultSet.getString("cognome");
            nome = resultSet.getString("nome");
            email = resultSet.getString("email");
            dataDiNascita = resultSet.getString("datadinascita");
            genere = resultSet.getString("genere");
            nazione = resultSet.getString("nazione");
            provincia = resultSet.getString("provincia");
            citta = resultSet.getString("citta");
            indirizzo = resultSet.getString("indirizzo");
            idUser = resultSet.getInt("user_id");
            Anagrafica anagrafica = new Anagrafica(cognome, nome, email, genere, dataDiNascita, nazione, provincia, citta, indirizzo, idUser);
            anagrafica.setId(resultSet.getInt("id"));

            return anagrafica;
        } catch (SQLException e) {
            System.out.println("Exception durante l'esecuzione della query:\n" + QUERY_READ);
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(Anagrafica anagraficaToUpdate) {

        Connection connection = ConnectionSingleton.getInstance();

        if(anagraficaToUpdate.getIdUser() == 0) {
            return false;
        }

        Anagrafica anagraficaRead = read(anagraficaToUpdate.getIdUser());
        if (!anagraficaRead.equals(anagraficaToUpdate)) {
            try {
                if (anagraficaToUpdate.getCognome() == null || anagraficaToUpdate.getCognome().equals("")) {
                    anagraficaToUpdate.setCognome(anagraficaRead.getCognome());
                }
                if (anagraficaToUpdate.getNome() == null || anagraficaToUpdate.getNome().equals("")) {
                    anagraficaToUpdate.setNome(anagraficaRead.getNome());
                }
                if (anagraficaToUpdate.getEmail() == null || anagraficaToUpdate.getEmail().equals("")) {
                    anagraficaToUpdate.setEmail(anagraficaRead.getEmail());
                }
                if (anagraficaToUpdate.getGenere() == null || anagraficaToUpdate.getGenere().equals("")) {
                    anagraficaToUpdate.setGenere(anagraficaRead.getGenere());
                }
                if (anagraficaToUpdate.getDataDiNascita() == null || anagraficaToUpdate.getDataDiNascita().equals("")) {
                    anagraficaToUpdate.setDataDiNascita(anagraficaRead.getDataDiNascita());
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
                preparedStatement.setInt(10, anagraficaToUpdate.getIdUser());
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

}
