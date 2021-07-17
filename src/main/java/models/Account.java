package models;

public class Account {

    private int accountId;
    private int number;
    private int balance;
    private int clientId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + accountId +
                ", number='" + number + '\'' +
                ", balance='" + balance + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
