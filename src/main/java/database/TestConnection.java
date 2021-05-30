package database;

import java.io.IOException;
import java.sql.*;

public class TestConnection {

    public static final String USER_NAME = "root";
    public static final String PASSWORD =  "rari35951745vV";
    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    public static Statement statement;
    public static Connection connection;

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
        Class.forName("com.mysql.cj.jdbc.Driver");

            statement.executeUpdate("CREATE TABLE carShop (" +
                    "id int auto_increment primary key," +
                    "name varchar(30) not null," +
                    "quantity varchar(10) not null," +
                    "price varchar(10) not null)");
            statement.executeUpdate("INSERT INTO carShop (name,quantity,price) value ('Patrol', 12, 12)");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM carShop");

            while (resultSet.next()){
                System.out.println(resultSet.getString(2) + " " +
                        resultSet.getString(3) + " " +
                        resultSet.getString(4));
        }
    }
}
