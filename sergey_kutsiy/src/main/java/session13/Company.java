package session13;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергей on 13.02.2016.
 */

@Entity
@Table(name = "COMPANIES")
public class Company {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COMPANIES_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MONEY")
    //@Convert (converter = MoneyConvertor.class)
    private int money;

    @OneToMany
    private Set <Employee> employees= new HashSet <> ();

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }


    public Company (String name, int money) {
        this.name = name;
        this.money=money;
    }


    public Company () {
    }

}
