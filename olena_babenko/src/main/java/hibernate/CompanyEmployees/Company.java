package hibernate.CompanyEmployees;
import hibernate.Convert.ConverterClass;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenchi on 13.02.16.
 */
@Entity
@Table(name = "COMPANY")
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COMPANY_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String name;

    @Column(name = "COMPANY_MONEY")
    @Convert(converter = ConverterClass.class)
    private double money;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();

    public Company(){
    }

    public Company(String name, double money){
        this.name = name;
        this.money = money;
    }

    public void hireEmpl(Employee employee){
        employees.add(employee);
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id.toString() +
                ", name='" + name.toString() + '\'' +
                ", money="+money+'\''+
                '}';
    }
}
