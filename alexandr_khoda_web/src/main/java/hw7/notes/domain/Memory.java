package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by s_okhoda on 16.02.2016.
 */
@Entity
@Table (name = "MEMORIES")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEM_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    private Vendor vendor;
    private int size;

    public Memory(Vendor vendor, int size) {
        this.vendor = vendor;
        this.size = size;
    }

    public Memory() {
    }

    @Override
    public String toString(){
        return "id=" + id + ", vendor=" + vendor + ", size=" + size;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
