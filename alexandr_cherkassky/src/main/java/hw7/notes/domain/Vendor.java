package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Пк2 on 20.02.2016.
 */
@Entity
@Table(name="Vendors")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "KHO_NOTES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private int id;

    @Column(name="name")
    private String vendorName;

    @OneToMany()
    private Set<Notebook> thisVendorNotes=new HashSet<>();

    public Vendor(){}
    public Vendor(String vendorName){
        this.vendorName=vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
