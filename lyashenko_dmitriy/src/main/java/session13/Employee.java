package session13;

import javax.persistence.*;

/**
 * Created by Solyk on 13.02.2016.
 */

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
//    @Id
//    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEES_SEQ",
//            allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "DEPARTMENT_ID")
    private Integer departments;

//    @ManyToOne
////    @Column(name = "COMPANYS_ID")
//    private Company company;

    public Employee(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDepartments() {
        return departments;
    }

    public void setDepartments(Integer departments) {
        this.departments = departments;
    }

    //    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", departments=" + departments +
                '}';
    }
}
