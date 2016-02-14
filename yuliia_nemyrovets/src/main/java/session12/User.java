package session12;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Юлия on 07.02.2016.
 */
@Entity
@Table(name = "USER_TABLE")
public class User {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERSEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String name;


    @Column(name = "USER_LOGIN")
    private String login;


    @Column(name = "USER_PASSWORD")
    private String password;


    @Column(name = "USER_DATE")
    private Date date;

    public User() {
    }


    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + " login" + login + "password" + password + "date" + date + '\'' + '}';
    }

}
