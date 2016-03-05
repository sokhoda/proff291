package hw9.taxi.domain;

import javax.persistence.*;

/**
 * Created by s_okhoda on 03.03.2016.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USER_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long uid;

    private String login;

    @Column(name = "ID_NUMBER")
    private String id;

    private String pass;

    public User() {
    }

    public User(String login, String id, String pass) {
        this.login = login;
        this.id = id;
        this.pass = pass;
    }
}
