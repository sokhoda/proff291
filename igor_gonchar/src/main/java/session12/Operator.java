package session12;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Home on 06.02.2016.
 */


@Entity
@Table(name = "OPERATORS")
public class Operator {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "OPERATORS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

        @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "REGISTER_DATE")
    private Date date;

    public Operator() {

    }

    public Operator(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "Id="+id +
                ", Login=" + login +
                ", Password='" + password + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
