package HibernateAuth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public interface MyObjDAO {
    public void save(MyObj object);

    public MyObj getById(int id);

}


@Entity
@Table(name = "Users")
public class Users {
    //  @name
    //  @SequenceGenerator(name = "sequence", sequenceName = "REGIONS_SEQ",
    //          allocationSize = 5, initialValue = 5)
    //  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public String getPas() {
        return password;
    }

    public void setPas(Long id) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name=" + name +
                ", password='" + password + '\'' +
                '}';
    }


}
