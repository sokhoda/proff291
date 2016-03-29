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

    @OneToMany
    private Set<Notebook> thisVendorNotes=new HashSet<>();

    @OneToMany (mappedBy = "thisVendor")
    private Set<CPU> thisVendorCpu;

    public Vendor(){}
    public Vendor(String vendorName){
        this.vendorName=vendorName;
        this.thisVendorCpu=new HashSet<>();
        this.thisVendorNotes=new HashSet<>();
    }

    public String getVendorName() {
        return vendorName;
    }

    public Set<Notebook> getThisVendorNotes() {
        return thisVendorNotes;
    }

    public Set<CPU> getThisVendorCpu() {
        return thisVendorCpu;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public void addCPU(CPU cpu){
        this.thisVendorCpu.add(cpu);
    }

    public void addNote(Notebook note){
        this.thisVendorNotes.add(note);
    }
}
