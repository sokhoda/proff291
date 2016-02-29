package hw7.notes.domain;

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
    @SequenceGenerator(name = "sequence", sequenceName = "VENDOR_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.REFRESH)
    private Set<Object> products = new HashSet<>();

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

    public Set<Object> getProducts() {
        return products;
    }

    public void setProducts(Set<Object> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
