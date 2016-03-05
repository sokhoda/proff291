package session15;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Сергей on 20.02.2016.
 */
@Entity
@Table(name = "EMPLOYEES")

public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "DEPARTMENT_ID")
    private String department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

}
