package database;

import models.Account;
import models.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AbstractRepository;
import repository.AccountRepository;
import repository.ClientRepository;
import spring.SpringConfig;

import java.io.IOException;
import java.sql.*;

public class TestConnection {

    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

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


/*        Client client = context.getBean("client", Client.class);
        client.setClientId(18);
        client.setLastName("sd34y");
        client.setSecondName("sdfy45u");
        client.setFirstName("dfuighsodiufg");
        client.setGender("male");*/

        ClientRepository clientRepository = new ClientRepository();

        System.out.println(clientRepository.getAll());


    }



}
