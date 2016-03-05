package hw7.notes.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


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

    @OneToMany(mappedBy = "notebook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Store> store = new HashSet<>();

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    public Notebook() {
    }

    public Notebook(String model, Vendor vendor, CPU cpu, Memory memory) {
        this.model = model;
        this.manufactureDate = new Date(new java.util.Date().getTime());
        this.vendor = vendor;
        this.cpu = cpu;
        this.memory = memory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setStore(Set<Store> store) {
        this.store = store;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public Set<Store> getStore() {
        return store;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void addStore(Store st) {
        store.add(st);
    }

//    private void addStore(Integer amount, Double price) {
//        store.add(new Store(new Notebook(model, vendor, cpu, memory), amount, price));


    @Override
    public String toString() {
        return "Notebook[" + " id=" + id + ",  VendorId=  "+vendor.getId()+"  VendorName= "+vendor.getName()+",  CPUId= "+cpu.getId()+
                cpu.getModel()+"  cpuVendor= "+cpu.getVendor().getName()+",   model= " + model  + ",  Date=" + manufactureDate + "]";
    }
}
