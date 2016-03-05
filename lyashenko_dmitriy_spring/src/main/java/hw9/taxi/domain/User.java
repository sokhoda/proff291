package hw9.taxi.domain;

import javax.persistence.*;

/**
 * Created by Solyk on 01.03.2016.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    public User(){}

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }




}
