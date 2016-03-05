package session13;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import session13.Employee.*;
/**
 * Created by Rrr on 13.02.2016.
 */

    @Entity
    @Table(name="COMPANY")
    public class Company {
        @Id
        @GeneratedValue
        @Column(name="ID")
        private Long id;

        @Convert(converter = ManyConverter.class)
        private Integer balance;

    private String name;

        @ OneToMany(mappedBy = "comp",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private Set<Employee> emp=new HashSet<>();

    public Company(){}

    public Company(Integer balance, String name) {
        this.balance = balance;
        this.name = name;
    }
    void addEmplToComp(Employee emp){
        this.emp.add(emp);
    }
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                ", emp=" + emp +
                '}';
    }
}
