package session14.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kris on 15.02.2016.
 */
@Entity
@Table(name = "VENDOR")//Производитель
public class Vendor {
    @Id
    @SequenceGenerator(name = "VENDOR_SEQ", sequenceName = "VENDOR_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VENDOR_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Notebook> notebooks = new HashSet<>();

    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<CPU> cpus = new HashSet<>();

    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Memory> memories = new HashSet<>();


    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public void setCpus(Set<CPU> cpus) {
        this.cpus = cpus;
    }

    public void setMemories(Set<Memory> memories) {
        this.memories = memories;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public Set<CPU> getCpus() {
        return cpus;
    }

    public Set<Memory> getMemories() {
        return memories;
    }

    public void addNotebook(Notebook note) {
        notebooks.add(note);
    }

    public void addCPU(CPU cpu) {
        cpus.add(cpu);
    }

    public void addMemory(Memory memory) {
        this.memories.add(memory);
    }
}
