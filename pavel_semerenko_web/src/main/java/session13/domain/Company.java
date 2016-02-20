package session13.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel on 13.02.2016.
 */
@Entity
public class Company {
    public Company() {
    }

    public Company(String companyName, Double money) {
        this.companyName = companyName;
        this.money = money;
    }

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sequence", sequenceName = "COMPANY_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "company_name")
    String companyName;

    @Column(name = "money")
    @Convert(converter = MoneyConverter.class)
    Double money;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Person> persons = new HashSet<>();

    public void addPerson(Person person){
        persons.add(person);
    }

    public Set<Person> getPersons() {
        return persons;
    }

    @Override
    public String toString() {
        return "Company{" +
                "money=" + money +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
