package spring.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "CPU_SEQ", sequenceName = "CPU_SEQ", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPU_SEQ")
    @Column(name = "CPU_ID")
    private Long id;

    @Column(name = "MODEL", length = 50)
    private String model;

    @Column(name = "FREQUENCY", length = 20)
    private String frequency;

    @OneToMany(mappedBy = "cpu" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<Notebook>();
    @ManyToOne
    private Vendor vendor;

    public CPU() {
    }

    public CPU(Vendor vendor, String model, String frequency) {
        this.vendor = vendor;
        this.model = model;
        this.frequency = frequency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public void addNotebook(Notebook note) {
        notebooks.add(note);
    }

    @Override
    public String toString() {
        return "CPU [" + "id=" + id + ", vendor='" + vendor + '\'' + ", model='" + model + '\'' + ", frequency=" + frequency + ']';
    }

}
