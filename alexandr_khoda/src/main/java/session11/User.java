package session11;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by s_okhoda on 27.12.2015.
 */
@Entity
@Table(name = "USERS")

public class User {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "KHO_USER_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String login;

    @Column(name = "PASS")
    private String pass;

    @Column(name = "CDATE")
    private GregorianCalendar regDate;

//    private double rate;
//    private boolean sex;

    public User(int id, String login, String pass, GregorianCalendar regDate) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.regDate = regDate;
//        this.rate = rate;
//        this.sex = sex;
    }

    public User() {
    }


    public User(String login, String pass){
        this(0, login, pass, new GregorianCalendar());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        User user = (User) obj;
        if ((login != null ? login.equals(user.getLogin()): user.getLogin() == null)
                && (pass != null ? pass.equals(user.getPass()): user.getPass() == null)
                && (regDate != null ? regDate.equals(user.getRegDate()): user.getRegDate() == null)
                ) {
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        return "\n" + getId() + ", " + getLogin() + ", " + getPass() + ", " +
                format1.format(getRegDate().getTime());
    }
    @Override
    public int hashCode() {
        int res = (login != null ? login.hashCode() : 0) +
                (pass != null ? pass.hashCode() : 0) +
                (regDate != null ? regDate.hashCode() : 0);
        return res;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GregorianCalendar getRegDate() {
        return regDate;
    }

    public void setRegDate(GregorianCalendar regDate) {
        this.regDate = regDate;
    }

}
