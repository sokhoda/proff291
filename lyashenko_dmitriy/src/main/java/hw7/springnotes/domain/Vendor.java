package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VENDOR_SEQ",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "vendorCPU", cascade = CascadeType.REFRESH)
    private Set<CPU> productsCpu = new HashSet<CPU>();

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.REFRESH)
    private Set<Notebook> productsNotes = new HashSet<Notebook>();

    @OneToMany(mappedBy = "vendorMemory", cascade = CascadeType.REFRESH)
    private Set<Memory> productsMems = new HashSet<Memory>();


    public Vendor(){}

    public Vendor(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CPU> getProductsCpu() {
        return productsCpu;
    }

    public void setProductsCpu(Set<CPU> productsCpu) {
        this.productsCpu = productsCpu;
    }

    public Set<Notebook> getProductsNotes() {
        return productsNotes;
    }

    public void setProductsNotes(Set<Notebook> productsNotes) {
        this.productsNotes = productsNotes;
    }

    public Set<Memory> getProductsMems() {
        return productsMems;
    }

    public void setProductsMems(Set<Memory> productsMems) {
        this.productsMems = productsMems;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
