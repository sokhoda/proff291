package hw7.springnotes.domain;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VENDOR_ID")
    private Vendor vendorMemory;


    @Column(name = "VOLUME")
    private Integer volume;

    @OneToMany(mappedBy = "memory", cascade = CascadeType.REFRESH)
    private Set<Notebook> notebooks = new HashSet<>();


    public Memory (){}

    public Memory(Vendor vendorMemory, Integer volume){
        this.vendorMemory = vendorMemory;
        this.volume = volume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendorMemory() {
        return vendorMemory;
    }

    public void setVendorMemory(Vendor vendorMemory) {
        this.vendorMemory = vendorMemory;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "volume=" + volume +
                ", id=" + id +
                ", vendorMemory=" + vendorMemory +
                '}';
    }
}
