package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VENDOR")
public class Vendor {
    @Id
    @SequenceGenerator(name = "VENDOR_SEQ", sequenceName = "VENDOR_SEQ", allocationSize = 1, initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VENDOR_SEQ")
    @Column(name = "VENDOR_ID")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Memory> memories = new HashSet<>();

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CPU> cpus = new HashSet<>();

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
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

    public void addNotebook(Notebook note) {
        notebooks.add(note);
    }

    public void addCPU(CPU cpu) {
        cpus.add(cpu);
    }

    public void addMemory(Memory memory) {
        this.memories.add(memory);
    }

    @Override
    public String toString() {
        return "Vendor[" + "id=" + id + ", name='" + name + '\'' + ']';
    }
}
