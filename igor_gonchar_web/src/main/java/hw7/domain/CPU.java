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

    @Column(name="Vendor")
    private String vendor;

    @Column(name = "FREQUENCY")
    private String frequency;

    @Column(name = "MODEL")
    private String model;

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();

    public CPU(){

    }

    public CPU(String vendor, String frequency, String model) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", vendor='" + vendor + '\'' +
                ", frequency='" + frequency + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }
}
