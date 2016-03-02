package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VENDOR_ID")
    private Vendor vendorCPU;

    @Column(name = "FREQUENCY")
    private Double frequency;

    @Column(name = "MODEL")
    private String model;

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.REFRESH)
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    public CPU(){}

    public CPU(Vendor vendor ,Double frequency, String model){
        this.vendorCPU = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendorCPU() {
        return vendorCPU;
    }

    public void setVendorCPU(Vendor vendor) {
        this.vendorCPU = vendor;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", vendor=" + vendorCPU +
                ", frequency=" + frequency +
                ", model='" + model + '\'' +
                '}';
    }
}
