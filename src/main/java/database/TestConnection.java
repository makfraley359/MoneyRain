package database;

import models.Account;
import models.Client;
import repository.AbstractRepository;
import repository.AccountRepository;
import repository.ClientRepository;

import java.io.IOException;
import java.sql.*;

public class TestConnection {

    public static final String USER_NAME = "root";
    public static final String PASSWORD =  "rari35951745vV";
    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try{
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.delete(1);


    }



}
