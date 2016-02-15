package session13.domain;

import javax.persistence.*;

/**
 * Created by s_okhoda on 13.02.2016.
 */
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEE_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    @ManyToOne
    private Company comp;

    public Employee(Long id, Company comp) {
        this.id = id;
        this.comp = comp;
    }

    public Employee(Company comp){
        this.comp = comp;
    }
    public Employee() {
    }

    @Override
    public String toString(){
        return "\nid=" + getId();
    }

    public String toString1(){
        return "\nid=" + getId() + ", company=[" + getComp().toString1()+"]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getComp() {
        return comp;
    }

    public void setComp(Company comp) {
        this.comp = comp;
    }
}
