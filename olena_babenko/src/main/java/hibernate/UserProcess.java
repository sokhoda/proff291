package hibernate;

import javax.persistence.*;

/**
 * Created by lenchi on 06.02.16.
 *
 * ЗАДАНИЕ
 с помощью Hibernate создать трёх пользователей.
 Затем пользователь вводит Id пользователя. Удалить данного пользователя

 */
@Entity
@Table(name = "USERS")
public class UserProcess {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "REGIONS_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_PASS")
    private String password;

    public UserProcess(){

    }

    public UserProcess(String name, String password){
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
