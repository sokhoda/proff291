package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Юлия on 19.02.2016.
 */

@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CPU_ID")
    private Long id;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "FREQUENCY")
    private String frequency;

    @Column(name = "CORE")
    private String core;


    @OneToMany(mappedBy = "CPU", cascade = CascadeType.REFRESH)
    private Set<Notebook> notebooks = new HashSet<>();

    public CPU() {
    }

    public CPU(String vendor, String frequency, String core) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.core = core;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public String toString() {
        return id + " " + vendor + " " + frequency + " " + core;
    }
}