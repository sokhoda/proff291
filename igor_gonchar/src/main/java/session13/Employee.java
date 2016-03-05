package session13;

import javax.persistence.*;

/**
 * Created by Home on 13.02.2016.
 */
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    private Company company;

    public void addCompany(Company company) {
        this.company = company;
    }

    public Employee() {

    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }
}
