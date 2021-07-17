package repository;

import models.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository extends AbstractRepository<Client, Integer> {


    public ClientRepository() throws SQLException {
    }

    public List<Client> getAll() throws SQLException {
        List<Client> clientList = new ArrayList<Client>();

        String sql = "SELECT CLIENTID, FIRSTNAME, SECONDNAME, LASTNAME, GENDER FROM CLIENT";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Client client = new Client();
            client.setClientId(resultSet.getInt("CLIENTID"));
            client.setFirstName(resultSet.getString("FIRSTNAME"));
            client.setSecondName(resultSet.getString("SECONDNAME"));
            client.setGender(resultSet.getString("GENDER"));
            client.setLastName(resultSet.getString("LASTNAME"));
            clientList.add(client);
            }
        closePrepareStatement(preparedStatement);
        return clientList;
    }

    public Client getEntityById(Integer id) throws SQLException {
        String sql = "SELECT CLIENTID, FIRSTNAME, SECONDNAME, LASTNAME, GENDER FROM CLIENT WHERE CLIENTID=?";
        Client client = new Client();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            client.setClientId(resultSet.getInt("CLIENTID"));
            client.setFirstName(resultSet.getString("FIRSTNAME"));
            client.setSecondName(resultSet.getString("SECONDNAME"));
            client.setLastName(resultSet.getString("LASTNAME"));
            client.setGender(resultSet.getString("GENDER"));
        }
        preparedStatement.executeQuery();
        closePrepareStatement(preparedStatement);
        return client;
    }

    public void update(Client entity) throws SQLException {
        String sql = "UPDATE CLIENT SET FIRSTNAME=?, SECONDNAME=?, GENDER=?, LASTNAME=? WHERE CLIENTID=?";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getSecondName());
        preparedStatement.setString(3, entity.getGender());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setInt(5, entity.getClientId());
        preparedStatement.executeUpdate();
        closePrepareStatement(preparedStatement);
    }

    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM CLIENT WHERE CLIENTID=?";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        closePrepareStatement(preparedStatement);
    }

    public void create(Client entity) throws SQLException {
        String sql = "INSERT INTO CLIENT (CLIENTID, FIRSTNAME, SECONDNAME, GENDER, LASTNAME) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        preparedStatement.setInt(1, entity.getClientId());
        preparedStatement.setString(2, entity.getFirstName());
        preparedStatement.setString(3, entity.getSecondName());
        preparedStatement.setString(4, entity.getGender());
        preparedStatement.setString(5, entity.getLastName());
        preparedStatement.executeUpdate();
        closePrepareStatement(preparedStatement);
    }
}
