package session13;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rrr on 13.02.2016.
 */

    @Entity
    @Table(name="EMPLOYEE")
    public class Employee {
        @Id
        @GeneratedValue
        @Column(name="ID")
        private Long id;


        @ ManyToOne
        private Company comp;

    public Employee(){}

    void addCompany(Company comp){
        this.comp=comp;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", comp=" + comp +
                '}';
    }
}
