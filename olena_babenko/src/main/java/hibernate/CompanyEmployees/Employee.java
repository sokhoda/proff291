package hibernate.CompanyEmployees;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenchi on 13.02.16.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEE_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Company company;

    public Employee() {
    }

    public Employee(Long id, Company company) {
        this.id =  id;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id.toString() +
                ", company='" + company.toString()+ '\'' +
                '}';
    }
}
