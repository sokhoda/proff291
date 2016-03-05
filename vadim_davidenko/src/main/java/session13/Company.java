package session13;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вадим on 13.02.2016.
 */
@Entity
@Table(name = "COMPANY")
public class Company {
    @Id
    @SequenceGenerator(name = "COMPANY_SEQ", sequenceName = "COMPANY_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_SEQ")

    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "BALANCE", length = 20)
    private Double balance;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employee = new HashSet<Employee>();

    public Company() {}

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", employee=" + employee +
                '}';
    }

    public Company(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
