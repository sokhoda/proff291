package session16TRANSCTION.domain;

import javax.persistence.*;

/**
 * Created by Solyk on 21.02.2016.
 */
@Entity
@Table(name = "EMPLOYEES")
public class Emloyee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "DEPARTMENT_ID")
    private Integer departments;

    public  Emloyee (){}

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

    @Override
    public String toString() {
        return "Emloyee{" +
                "id=" + id +
                ", departments=" + departments +
                '}';
    }
}
