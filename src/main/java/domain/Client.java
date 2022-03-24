package domain;

public class Client {
    
    private int clientId;
    private String name;
    private String surname;
    private String email;
    private int phone;
    private double balance;

    public Client(){
    }
    
    public Client(int clientId) {
        this.clientId = clientId;
    }

    public Client(String name, String surname, String email, int phone, double balance) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public Client(int clientId, String name, String surname, String email, int phone, double balance) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", balance=" + balance + '}';
    }
    
}
