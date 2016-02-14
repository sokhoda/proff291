package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Вадим on 14.02.2016.
 *
 * модель, дата производства, производитель, процессор, память
 */

@Entity
@Table(name = "NOTEBOOKS")
@SequenceGenerator(name = "NOTEBOOKS_SEQ", sequenceName = "NOTEBOOKS_SEQ",
        allocationSize = 1, initialValue = 1000)

public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTEBOOKS_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "MODEL", length = 50)
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @ManyToOne
    @Column(name = "VENDOR", length = 20)
    private Vendor vendor;

    @ManyToOne
    @Column(name = "CPU", length = 20)
    private CPU cpu;

    @ManyToOne
    @Column(name = "MEMORY", length = 20)
    private Memory memory;

    @ManyToOne
    @Column(name = "STORE", length = 20)
    private Store store;

    public Notebook() {}

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufactureDate=" + manufactureDate +
                '}';
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
}
