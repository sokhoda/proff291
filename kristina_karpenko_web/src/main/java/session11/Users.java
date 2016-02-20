package session11;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_REGISTER")
    private Date dateRegistration;

    public Users() {
    }

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    @Override
    public String toString() {
        return "USER{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password ='"+password+'\''+
                ",date registration='"+dateRegistration+'\''+
                '}';
    }
}
