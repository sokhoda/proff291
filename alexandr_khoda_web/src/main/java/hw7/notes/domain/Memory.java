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
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    @Column(name = "VenID")
    private Long vendorId;
    @Column(name = "sizze")
    private String size;

    public Memory(Long vendorId, String size) {
        this.vendorId = vendorId;
        this.size = size;
    }

    public Memory() {
    }

    @Override
    public String toString(){
        return "id=" + id + ", vendorId=" + vendorId + ", size=" + size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
