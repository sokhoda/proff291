package session14.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Kris on 15.02.2016.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "BOOKS_SEQ", sequenceName = "BOOKS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKS_SEQ")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;//производитель

    @Column(name = "MODEL")
    private String model;

    @ManyToOne
    private CPU cpu;

    @ManyToOne
    private Memory memories;

    @Temporal(TemporalType.DATE)
    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @ManyToOne
    //  @Column(name = "STORE")
    private Store store;

    public Notebook() {
    }

    public Notebook(Vendor vendor, String model, CPU cpu, Memory memory, Store store, Date manufactureDate) {
        this.vendor = vendor;
        this.model = model;
        this.cpu = cpu;
        this.memories = memory;
        this.manufactureDate = manufactureDate;
        this.store = store;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setMemories(Memory memories) {
        this.memories = memories;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Memory getMemories() {
        return memories;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public Store getStore() {
        return store;
    }
}
