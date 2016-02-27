package session14;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергей on 13.02.2016.
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEES_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    private Company company;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;


    public void setCompany(Company company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Employee (Company company, String firstName, String lastName)    {
        this.company=company;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Employee () {

    }
}
