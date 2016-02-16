package hw7.domain;

import session14.Employee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 14.02.2016.
 */
@Entity
@Table(name="VENDORS")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VENDORS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();

 /*   @OneToMany(mappedBy = "cpu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CPU> cpus = new HashSet<>();*/

    public Vendor(){

    }

    public Vendor(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
