package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String fname;

    @Column(name = "LAST_NAME")
    private String sname;

    @Column(name = "PASSWORD")
    private String pass;

    public User() {
    }

    public User(String fname, String sname, String pass) {
        this.fname = fname;
        this.sname = sname;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
