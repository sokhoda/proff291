package session13.domain2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Юлия on 13.02.2016.
 */
@Entity
@Table(name = "Company1")
public class Company {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANIES",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;


    @Column(name = "COUNT")
    private Double count;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Persons> persons = new HashSet<>();

    public Company() {
    }

    public Company( double count, String name) {

        this.count = count;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Persons> getPersons() {
        return persons;
    }

    public void setPersons(Set<Persons> persons) {
        this.persons = persons;
    }

    public boolean add(Persons person) {

        return persons.add(person);


    }

    @Override
    public String toString() {
        return "id"+id+"name+"+name +"persons"+persons+"acount"+count;
    }
}
