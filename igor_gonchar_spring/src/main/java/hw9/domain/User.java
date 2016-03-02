package hw9.domain;

import javax.persistence.*;

/**
 * Created by i.gonchar on 2/29/2016.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ",
            allocationSize = 1, initialValue = 1)
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IDENTITY_NUMBER")
    private long identityNumber;

    public User(){
    }

    public User(String login, String password, long identityNumber) {
        this.login = login;
        this.password = password;
        this.identityNumber = identityNumber;
    }

}
