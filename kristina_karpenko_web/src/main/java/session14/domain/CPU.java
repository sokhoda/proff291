package session14.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kris on 15.02.2016.
 */
@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "CPU_SEQ", sequenceName = "CPU_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPU_SEQ")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "FREQUENCY")
    private Long frequency;

    @Column(name = "MODEL")
    private String model;

    @OneToMany(mappedBy = "cpu",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Notebook> notebooks = new HashSet<>();

    public CPU() {
    }

    public CPU(Vendor vendor, String model, Long frequency) {
        this.frequency = frequency;
        this.model = model;
        this.vendor = vendor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Long getFrequency() {
        return frequency;
    }

    public String getModel() {
        return model;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void addNotebook(Notebook note) {
        notebooks.add(note);
    }
}
