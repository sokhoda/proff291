package hw7.notes.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOK_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VENDOR_ID")
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactoreDate;

    @ManyToOne
    @JoinColumn(name = "CPU_ID")
    private CPU cpu;

    @ManyToOne
    @JoinColumn(name = "MEMORY_ID")
    private Memory memory;

    @OneToMany(mappedBy = "notebook", cascade = CascadeType.REFRESH)
    private Set<Store> stores = new HashSet<>();

    public Notebook(){}
    public Notebook(Vendor vendor, String model, Date manufactoreDate, CPU cpu, Memory memory){
        this.vendor = vendor;
        this.model = model;
        this.manufactoreDate = manufactoreDate;
        this.cpu = cpu;
        this.memory = memory;
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

    public Date getManufactoreDate() {
        return manufactoreDate;
    }

    public void setManufactoreDate(Date manufactoreDate) {
        this.manufactoreDate = manufactoreDate;
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

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    @Override
    public String  toString() {
        return "Notebook{" +
                "memory=" + memory +
                ", cpu=" + cpu +
                ", manufactoreDate=" + manufactoreDate +
                ", model='" + model + '\'' +
                ", vendor=" + vendor +
                ", id=" + id +
                '}';
    }
}
