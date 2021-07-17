package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractRepository<E, K> {

    public static final String USER_NAME = "root";
    public static final String PASSWORD =  "rari35951745vV";
    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private Connection connection;


    public AbstractRepository() throws SQLException {
        connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    public abstract List<E> getAll() throws SQLException;
    public abstract E getEntityById(K id) throws SQLException;
    public abstract void update(E entity) throws SQLException;
    public abstract void delete(K id) throws SQLException;
    public abstract void create(E entity) throws SQLException;

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void initDB() {
        try {
            String s;
            FileReader fileReader = new FileReader(new File("src/main/resources/CreateTable.sql"));
            BufferedReader br = new BufferedReader(fileReader);

            while((s = br.readLine()) != null){
                PreparedStatement ps = getPrepareStatement(s);
                ps.executeUpdate(s);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}