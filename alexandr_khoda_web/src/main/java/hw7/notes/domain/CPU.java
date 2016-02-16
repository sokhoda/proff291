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
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    private Vendor vendor;
    private Double freq;
    private String model;


    public CPU(Vendor vendor, Double freq, String model) {
        this.vendor = vendor;
        this.freq = freq;
        this.model = model;
    }

    public CPU() {
    }

    @Override
    public String toString(){
        return "id=" + id + ", vendor=" + vendor + ", " + String.format("%" +
                ".2f", freq)  + ", model=" + model;
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
