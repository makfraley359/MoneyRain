package repository;

import models.Account;
import models.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.SpringConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository extends AbstractRepository<Account, Integer> {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    public AccountRepository() throws SQLException {
    }

    public List<Account> getAll() throws SQLException {
        List<Account> accountList = new ArrayList<Account>();

        String sql = "SELECT ACCOUNTID, NUMBER, BALANCE, CLIENTID FROM CLIENT";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Account account = context.getBean("account", Account.class);
            account.setAccountId(resultSet.getInt("ACCOUNTID"));
            account.setNumber(resultSet.getInt("NUMBER"));
            account.setBalance(resultSet.getInt("BALANCE"));
            account.setClientId(resultSet.getInt("CLIENTID"));
            accountList.add(account);
        }
        closePrepareStatement(preparedStatement);
        return accountList;
    }

    public Account getEntityById(Integer id) throws SQLException {
        String sql = "SELECT ACCOUNTID, NUMBER, BALANCE, CLIENTID FROM ACCOUNT WHERE ACCOUNTID=?";
        Account account = context.getBean("account", Account.class);
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            account.setAccountId(resultSet.getInt("ACCOUNTID"));
            account.setNumber(resultSet.getInt("NUMBER"));
            account.setBalance(resultSet.getInt("BALANCE"));
            account.setClientId(resultSet.getInt("CLIENTID"));
        }
        preparedStatement.executeQuery();
        closePrepareStatement(preparedStatement);
        return account;
    }

    public void update(Account entity) throws SQLException {
        String sql = "UPDATE ACCOUNT SET CLIENTID=?, NUMBER=?, BALANCE=? WHERE ACCOUNTID=?";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        preparedStatement.setInt(1, entity.getClientId());
        preparedStatement.setInt(2, entity.getNumber());
        preparedStatement.setInt(3, entity.getBalance());
        preparedStatement.setInt(4, entity.getAccountId());
        preparedStatement.executeUpdate();
        closePrepareStatement(preparedStatement);
    }

    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM ACCOUNT WHERE ACCOUNTID=?";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        closePrepareStatement(preparedStatement);

    }

    public void create(Account entity) throws SQLException {
        String sql = "INSERT INTO ACCOUNT (ACCOUNTID, NUMBER, BALANCE, CLIENTID) VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        preparedStatement.setInt(1, entity.getAccountId());
        preparedStatement.setInt(2, entity.getNumber());
        preparedStatement.setInt(3, entity.getBalance());
        preparedStatement.setInt(4, entity.getClientId());
        preparedStatement.executeUpdate();
        closePrepareStatement(preparedStatement);
    }
}
