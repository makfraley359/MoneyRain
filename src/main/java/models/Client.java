package models;

public class Client {

    private int clientId;
    private String firstName;
    private String secondName;
    private String gender;
    private String lastName;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + clientId +
                ", name='" + firstName + '\'' +
                ", surname='" + secondName + '\'' +
                ", gender='" + gender + '\'' +
                ", patronymic='" + lastName + '\'' +
                '}';
    }
}
