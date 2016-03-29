package session14.domainHW7;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вадим on 14.02.2016.
 *
 * имя
 */

@Entity
@Table(name = "VENDOR")
@SequenceGenerator(name = "VENDOR_SEQ", sequenceName = "VENDOR_SEQ",
        allocationSize = 1, initialValue = 4001)

public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VENDOR_SEQ")
    @Column(name = "VENDOR_ID")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @OneToMany(mappedBy = "vendor")
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    public Vendor() {}

    public Vendor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }
}
