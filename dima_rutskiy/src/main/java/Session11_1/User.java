package Session11_1;

import javax.persistence.*;

/**
 * Created by Rrr on 06.02.2016.
 */

    @Entity

@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "REGIONS_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    public User() {
    }

    public User(String name,String surname) {

        this.name = name;
        this.surname = surname;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surname;
    }

    public void setSurName(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name +
                "surname=" + surname +'\'' +
                '}';
    }
}