package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Пк2 on 20.02.2016.
 */
@Entity
@Table(name="CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU seq",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private int id;

    @Column(name="CPU MODEL")
    private String cpuModel;

    @Column(name="CPU FREQUENCY")
    private Double cpuFreq;

    @ManyToOne
    @JoinColumn(name="VENDOR NAME", referencedColumnName = "NAME")
    private Vendor thisVendor;

    @OneToMany
    //@JoinColumn(name="NOTE MODEL")
    private Set<Notebook> thisCPUNotes;

    private CPU(){}
    private CPU(String cpuModel, Double frequency){
        this.cpuModel=cpuModel;
        this.cpuFreq=frequency;
        this.thisCPUNotes=new HashSet<Notebook>();
    }


    public String getCPUModel() {
        return cpuModel;
    }

    public Double getCpuFreq() {
        return cpuFreq;
    }

    public Vendor getThisVendor() {
        return thisVendor;
    }

    public Set<Notebook> getThisCPUNotes() {
        return thisCPUNotes;
    }


    public void setCPUModel(String model) {
        this.cpuModel = model;
    }

    public void setCpuFreq(Double cpuFreq) {
        this.cpuFreq = cpuFreq;
    }

    public void setThisVendor(Vendor thisVendor) {
        this.thisVendor = thisVendor;
    }

    public void addNotebook(Notebook note){
        this.thisCPUNotes.add(note);
    }

}
