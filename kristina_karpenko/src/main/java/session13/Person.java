package session13;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Person {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "PERSONS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @ManyToOne
   // @Column(name = "COMPANY_ID")
    private Company company;

    public Person(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
