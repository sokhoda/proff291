package hw9.taxi.domain;

import javax.persistence.*;

/**
 * Created by Юлия on 02.03.2016.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_USERS",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_LOGIN")
    private String login;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_IDENTIFICATION_NUMBER")
    private String idNumber;

    public User() {
    }

    public User(String login, String password, String idNumber) {
        this.login = login;
        this.password = password;
        this.idNumber = idNumber;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
