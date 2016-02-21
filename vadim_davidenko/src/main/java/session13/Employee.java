package session13;

import javax.persistence.*;

/**
 * Created by Вадим on 13.02.2016.
 */

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @SequenceGenerator(name = "EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")

    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Company company;

    public Employee() {}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }

    public Employee(Company company) {
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
}
