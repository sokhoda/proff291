package session13;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Solyk on 13.02.2016.
 */
@Entity
@Table(name = "COMPANYS")
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COMPANYS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAMES")
    private String name;

    @Column(name = "BALANCES")
    @Convert(converter = ManeyConverter.class)
    private Double balance;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "EMPLOYEES_ID")
    private Set<Employee> employees = new HashSet<>();

    public Company(){

    }

    public Company(String name, Double balance){
        this.name = name;
        this.balance = balance;

    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", employees=" + employees +
                '}';
    }
}
