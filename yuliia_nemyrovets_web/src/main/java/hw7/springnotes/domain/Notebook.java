//package hw7.springnotes.domain;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by Юлия on 19.02.2016.
// */
//@Entity
//@Table(name = "NOTEBOOKS")
//public class Notebook  {
//    @Id
//    @SequenceGenerator(name = "sequence", sequenceName = "SEQUENCE1",
//            allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
//    @Column(name = "NOTEBOOK_ID")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "VENDOR_ID")
//    private Vendor vendor;
//
//    @ManyToOne
//    @JoinColumn (name = "CPU_ID")
//    private Cpu  cpu;
//
//    @ManyToOne
//    @JoinColumn(name = "MEMORY_ID")
//    private Memory memory;
//
//    @Column(name = "MODEL")
//    private String model;
//
//    @Column(name = "MANUFACTURE_DATE")
//    private Date date;
//
//    @Column(name = "PRICE")
//    private double price;
//
//
//    @OneToMany(mappedBy = "NOTEBOOKS",cascade = CascadeType.DETACH)
//    private Set<Store> store=new HashSet<>();
//
//    public Notebook() {
//    }
//
//    public Notebook(Vendor vendor, Cpu cpu, Memory memory, String model, double price) {
//        this.vendor = vendor;
//        this.cpu = cpu;
//        this.memory = memory;
//        this.model = model;
//        date = new java.sql.Date(new java.util.Date().getTime());
//        this.price = price;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Vendor getVendor() {
//        return vendor;
//    }
//
//    public void setVendor(Vendor vendor) {
//        this.vendor = vendor;
//    }
//
//    public Cpu getCpu() {
//        return cpu;
//    }
//
//    public void setCpu(Cpu cpu) {
//        this.cpu = cpu;
//    }
//
//    public Memory getMemory() {
//        return memory;
//    }
//
//    public void setMemory(Memory memory) {
//        this.memory = memory;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public Set<Store> getStore() {
//        return store;
//    }
//
//    public void setStore(Set<Store> store) {
//        this.store = store;
//    }
//
//    @Override
//    public String toString() {
//        return "Notebook{" +
//                "id=" + id +
//                ", vendor=" + vendor +
//                ", cpu=" + cpu +
//                ", memory=" + memory +
//                ", model='" + model + '\'' +
//                ", date=" + date +
//                ", price=" + price +
//                ", store=" + store +
//                '}';
//    }
//}
