package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VENDOR")
@SequenceGenerator(name = "sequence", sequenceName = "VENDOR_SEQ")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VENDOR_SEQ")
    @Column(name = "VENDOR_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.REFRESH)
    private Set<CPU> cpus;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.REFRESH)
    private Set<Memory> memories;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.REFRESH)
    private Set<Notebook> notebooks;

    public Vendor() {
        notebooks = new HashSet<>();
        cpus = new HashSet<>();
        memories = new HashSet<>();

    }

    public Set<CPU> getCpus() {
        return cpus;
    }

    public void setCpus(Set<CPU> cpus) {
        this.cpus = cpus;
    }

    public Set<Memory> getMemories() {
        return memories;
    }

    public void setMemories(Set<Memory> memories) {
        this.memories = memories;
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
