package session13;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 13.02.2016.
 */
@Entity
@Table(name="Companies")
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CCMPANIES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name="Balance")
    @Convert(converter = MoneyConverter.class)
    private int balance;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();

    public Company(){

    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public Company(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
