package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CPU")
@SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ")
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPU_SEQ")
    @Column(name = "CPU_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "FREQUENCY")
    private Integer frequency;

    @Column(name = "MODEL")
    private String model;

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.REFRESH)
    private Set<Notebook> notebooks;

    public CPU() {
        notebooks = new HashSet<>();

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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
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
