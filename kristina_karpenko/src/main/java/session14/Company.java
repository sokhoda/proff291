package session14;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPANYS")
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COMPANYS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "MONEY")
    private Long money;
    @OneToMany
    private Set<Person> persons = new HashSet<>() ;


    public Company( String name, Long money) {
               this.name = name;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getMoney() {
        return money;
    }

    public Set<Person> getPers() {
        return persons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public void setPers(Person pers) {
        persons.add(pers);
    }
}
