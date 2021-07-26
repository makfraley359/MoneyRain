package database;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ClientRepository clientRepository = context.getBean("clientRepository", ClientRepository.class);
        System.out.println(clientRepository.getAll());

    }



}
