package hw7.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 14.02.2016.
 */
@Entity
@Table(name="CPUS")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COUS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "FREQUENCY")
    private String frequency;

    @Column(name = "MODEL")
    private String model;

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();

    public CPU(){

    }

    public CPU(String frequency, String model) {
        this.frequency = frequency;
        this.model = model;
    }
}
