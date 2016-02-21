package session14.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kris on 15.02.2016.
 */
@Entity
@Table(name = "MEMORIES")
public class Memory {
    @Id
    @SequenceGenerator(name = "MEMORIES_SEQ", sequenceName = "MEMORIES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMORIES_SEQ")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "SIZE")
    private Long size;

    @OneToMany(mappedBy = "memories", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();

    public Memory() {
    }

    public Memory(Vendor vendor, Long size) {
        this.vendor = vendor;
        this.size = size;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Long getSize() {
        return size;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void addNotebook(Notebook note) {
        notebooks.add(note);
    }
}
