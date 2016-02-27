package hw7.domain;

import session14.Company;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 14.02.2016.
 */

@Entity
@Table(name="NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name ="MODEL")
    private String model;

    @Column(name ="MANUFACTURE_DATE")
    private Date manufactureDate;

    @ManyToOne
    private CPU cpu;

    @ManyToOne
    private Memory memory;

    @ManyToOne
    private Store store;

    public Notebook(){

    }

    public Notebook(Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", vendor=" + vendor.getName() +
                ", model='" + model + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", cpu=" + cpu.getModel() +
                ", memory=" + memory.getSize() +
                ", store=" + store +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
