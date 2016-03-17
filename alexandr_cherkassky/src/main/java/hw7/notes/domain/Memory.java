package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Пк2 on 20.02.2016.
 */
@Entity
@Table(name="Memory")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Memory SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private int id;

    @Column
    private String memModel;

    @Column(name="MEMORY SIZE")
    private Double memSize;

    @ManyToOne
    @JoinColumn(name="MEM VENDOR",referencedColumnName = "name")
    private Vendor memVendor;

    @OneToMany(mappedBy="noteMemory", cascade = CascadeType.ALL)
    private Set<Notebook> thisMemoryNotes;

    public Memory(){}
    public Memory(String memModel,Double size){
        this.memModel=memModel;
        this.memSize=size;
        this.thisMemoryNotes=new HashSet<>();
    }

    public String getMemModel() {
        return memModel;
    }

    public Double getMemSize() {
        return memSize;
    }

    public Vendor getMemVendor() {
        return memVendor;
    }

    public Set<Notebook> getThisMemoryNotes() {
        return thisMemoryNotes;
    }

    public void addNote(Notebook note){
        this.thisMemoryNotes.add(note);
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", memModel='" + memModel + '\'' +
                ", memSize=" + memSize +
                ", memVendor=" + memVendor.getVendorName() +
                '}';
    }
}
