package Session16.entity;

import javax.persistence.*;

/**
 * Created by Пк2 on 21.02.2016.
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="SALARY")
    private Integer salary;

    public  Employee(){}
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName +", Salary="+salary+"]"+"\n";
    }


}
