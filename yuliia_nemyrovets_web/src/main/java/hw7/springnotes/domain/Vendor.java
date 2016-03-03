//package hw7.springnotes.domain;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by Юлия on 19.02.2016.
// */
//
//@Entity
//@Table(name = "VENDOR")
//public class Vendor {
//    @Id
//    @SequenceGenerator(name = "sequence", sequenceName = "VEN_SEQ",
//            allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
//    @Column(name = "VENDOR_ID")
//    private Long id;
//
//    @Column(name = "VENDOR_NAME")
//    private String name;
//
//    @OneToMany(mappedBy = "VENDOR", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Notebook> notebooks = new HashSet<>();
//
//    @OneToMany(mappedBy = "VENDOR", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Memory> memory = new HashSet<>();
//
//    @OneToMany(mappedBy = "VENDOR", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Cpu> cpu = new HashSet<>();
//
//
//    public Vendor() {
//    }
//
//    public Vendor(String name) {
//        this.name = name;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<Notebook> getNotebooks() {
//        return notebooks;
//    }
//
//    public void setNotebooks(Set<Notebook> notebooks) {
//        this.notebooks = notebooks;
//    }
//
//    public Set<Memory> getMemory() {
//        return memory;
//    }
//
//    public void setMemory(Set<Memory> memory) {
//        this.memory = memory;
//    }
//
//    public Set<Cpu> getCpu() {
//        return cpu;
//    }
//
//    public void setCpu(Set<Cpu> cpu) {
//        this.cpu = cpu;
//    }
//}