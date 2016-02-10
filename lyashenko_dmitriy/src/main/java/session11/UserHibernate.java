package session11;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Solyk on 06.02.2016.
 */

@Entity
@Table(name = "USERS")
public class UserHibernate {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGINS")
    private String login;

    @Column(name = "PASSWORDS")
    private String password;


    @SequenceGenerator(name = "sop", sequenceName = "TO_DATE(SYSDATE)")
    @GeneratedValue(strategy  = GenerationType.AUTO, generator = "sop")
    @Column(name = "DATES_REGISTRATION")
    private Date dateOfRegistration;

    public UserHibernate(){

    }
    public UserHibernate(String login, String password){
        this.login = login;
        this.password = password;


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

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public String toString() {
        return "UserHibernate{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                '}';
    }
}
