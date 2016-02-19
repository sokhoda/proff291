package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEMORY")
@SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMORY_SEQ")
    @Column(name = "MEMORY_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "SIZE")
    private Integer size;

    @OneToMany(mappedBy = "memory", cascade = CascadeType.REFRESH)
    private Set<Notebook> notebooks;

    public Memory() {
        notebooks = new HashSet<>();
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }
}
