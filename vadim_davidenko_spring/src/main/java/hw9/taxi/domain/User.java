package hw9.taxi.domain;

import javax.persistence.*;

/**
 * Created by Вадим on 28.02.2016.
 *
 * String login, String id, String pass
 *
 */

@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ",
        allocationSize = 1, initialValue = 1)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN", length = 50, unique = true)
    private String login;

    @Column(name = "ID_NUMBER", length = 20)
    private String idNumber;

    @Column(name = "PSW", length = 50)
    private String password;

    public User() {}

    public User(String login, String idNumber, String password) {
        this.login = login;
        this.idNumber = idNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
