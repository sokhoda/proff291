package session13.domain;

import javax.persistence.*;

/**
 * Created by Pavel on 13.02.2016.
 */
@Entity
public class Person {

    public Person() {
    }

    public Person(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sequence", sequenceName = "PERSONS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "serial_number")
    String serialNumber;

    @ManyToOne
    private Company company;

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", company=" + company +
                '}';
    }
}
