//package hw7.notes.domain;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by Юлия on 19.02.2016.
// */
//@Entity
//@Table(name = "MEMORY")
//public class Memory {
//    @Id
//    @SequenceGenerator(name = "sequence", sequenceName = "MEM_SEQ",
//            allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
//    @Column(name = "MEMORY_ID")
//    private Long id;
//
//    @Column(name = "VENDOR")
//    private String vendor;
//
//    @Column(name = "MEMORY_SIZE")
//    private Long size;
//
//    @OneToMany(mappedBy = "MEMORY", cascade = CascadeType.REFRESH)
//    private Set<Notebook> notebooks = new HashSet<>();
//
//    public Memory() {
//    }
//
//    public Memory(String vendor, Long size) {
//        this.vendor = vendor;
//        this.size = size;
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
//    public String getVendor() {
//        return vendor;
//    }
//
//    public void setVendor(String vendor) {
//        this.vendor = vendor;
//    }
//
//    public Long getSize() {
//        return size;
//    }
//
//    public void setSize(Long size) {
//        this.size = size;
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
//    @Override
//    public String toString() {
//        return id+ " "+ vendor+ " "+ size;
//    }
//}
