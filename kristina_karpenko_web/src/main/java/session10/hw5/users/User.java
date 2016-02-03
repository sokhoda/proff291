package session10.hw5.users;


import java.sql.Date;

public class User {
    private int id;
    private String userName;
    private String password;
    private Date dateRegistration;

    public User() {
           }

    public User(int id, String userName, String password, Date dateRegistration) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.dateRegistration = dateRegistration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }
}
