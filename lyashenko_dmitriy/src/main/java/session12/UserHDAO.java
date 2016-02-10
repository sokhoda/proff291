package session12;

import javax.persistence.*;

/**
 * Created by Solyk on 07.02.2016.
 */
@Entity
@Table(name = "USERS")
public class UserHDAO {

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

    public UserHDAO(){}

    public UserHDAO(String login, String password){
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

    @Override
    public String toString() {
        return "UserHDAO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
