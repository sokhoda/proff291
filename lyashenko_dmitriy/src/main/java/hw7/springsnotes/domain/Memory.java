package hw7.springsnotes.domain;



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
    private hw7.springsnotes.domain.Vendor vendorMemory;


    @Column(name = "VOLUME")
    private Integer volume;

    @OneToMany(mappedBy = "memory", cascade = CascadeType.REFRESH)
    private Set<hw7.springsnotes.domain.Notebook> notebooks = new HashSet<>();


    public Memory (){}

    public Memory(hw7.springsnotes.domain.Vendor vendorMemory, Integer volume){
        this.vendorMemory = vendorMemory;
        this.volume = volume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public hw7.springsnotes.domain.Vendor getVendorMemory() {
        return vendorMemory;
    }

    public void setVendorMemory(hw7.springsnotes.domain.Vendor vendorMemory) {
        this.vendorMemory = vendorMemory;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Set<hw7.springsnotes.domain.Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<hw7.springsnotes.domain.Notebook> notebooks) {
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
