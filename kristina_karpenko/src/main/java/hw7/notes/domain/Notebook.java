package hw7.notes.domain;

import javax.persistence.*;
import java.sql.Date;

import static hw7.notes.util.Utils.DATEFORMAT_COMMON;


@Entity
@Table(name = "NOTEBOOK")
public class Notebook {
    @Id
    @SequenceGenerator(name = "NOTEBOOK_SEQ", sequenceName = "NOTEBOOK_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTEBOOK_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "MODEL", length = 50)
    private String model;

    @ManyToOne
    @JoinColumn(name = "VENDOR_ID")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "CPU_ID")
    private CPU cpu;

    @ManyToOne
    @JoinColumn(name = "MEMORY_ID")
    private Memory memory;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    public Notebook() {}

    public Notebook(String model, Vendor vendor, CPU cpu, Memory memory, Store store,java.util.Date manufactureDate) {
        this.model = model;
        this.manufactureDate =  new Date(manufactureDate.getTime());
        this.vendor = vendor;
        this.cpu = cpu;
        this.memory = memory;
        this.store = store;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Transient
    public String getManufactureDateStr() {
        if (manufactureDate != null) {
            return DATEFORMAT_COMMON.get().format(manufactureDate);
        }
        return "";
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
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

    @Override
    public String toString() {
        return "Notebook[" + "id=" + id + ", model='" + model + '\'' + ", manufactureDate=" + manufactureDate + ']';
    }
}
