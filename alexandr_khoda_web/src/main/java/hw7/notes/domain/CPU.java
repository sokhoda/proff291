package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by s_okhoda on 16.02.2016.
 */
@Entity
@Table (name = "CPUS")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    private Long vendorId;
    private Double freq;
    private String model;


    public CPU(Long vendorId, Double freq, String model) {
        this.vendorId = vendorId;
        this.freq = freq;
        this.model = model;
    }

    public CPU() {
    }

    @Override
    public String toString(){
        return "id=" + id + ", vendorId=" + vendorId + ", " + String.format
                ("%.2f", freq)  + ", model=" + model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Double getFreq() {
        return freq;
    }

    public void setFreq(Double freq) {
        this.freq = freq;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
