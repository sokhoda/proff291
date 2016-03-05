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
//@Table(name = "CPU")
//public class Cpu {
//    @Id
//    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ",
//            allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
//    @Column(name = "CPU_ID")
//    private Long id;
//
//    @Column(name = "MODEL")
//    private String model;
//
//    @Column(name = "FREQUENCY")
//    private String frequency;
//
//    @Column(name = "CORE")
//    private String core;
//
//
//    @OneToMany(mappedBy = "CPU", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Notebook> notebooks = new HashSet<>();
//
//    @ManyToOne
//    private Vendor vendor;
//
//    public Cpu() {
//    }
//
//    public Cpu(String model, String frequency, String core, Vendor vendor) {
//        this.model = model;
//        this.frequency = frequency;
//        this.core = core;
//        this.vendor=vendor;
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
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public String getFrequency() {
//        return frequency;
//    }
//
//    public void setFrequency(String frequency) {
//        this.frequency = frequency;
//    }
//
//    public String getCore() {
//        return core;
//    }
//
//    public void setCore(String core) {
//        this.core = core;
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
//    public Vendor getVendor() {
//        return vendor;
//    }
//
//    public void setVendor(Vendor vendor) {
//        this.vendor = vendor;
//    }
//
//    @Override
//    public String toString() {
//        return "CPU{" +
//                "id=" + id +
//                ", model='" + model + '\'' +
//                ", frequency='" + frequency + '\'' +
//                ", core='" + core + '\'' +
//                ", vendor=" + vendor +
//                '}';
//    }
//}