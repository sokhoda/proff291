package hw7.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 14.02.2016.
 */
@Entity
@Table(name="MEMORIES")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORIES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name="MEM_SIZE")
    private int size;

    @Column(name="Vendor")
    private String vendor;

    @OneToMany(mappedBy = "memory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();

    public Memory(){
    }

    public Memory(String vendor, int size) {
        this.vendor = vendor;
        this.size = size;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public long getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", vendor='" + vendor + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
