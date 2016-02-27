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

    @Column(name="memory_name")
    private String memoryName;

    @ManyToOne
    private Set<Vendor> vendor=new HashSet<>();

    @OneToMany
    private Set<Notebook> thisMemoryNotes=new HashSet<>();

    public Memory(){}
    public Memory(String memoruName){
        this.memoryName=memoruName;
    }

    public String getMemoryName() {
        return memoryName;
    }

    public void setMemoryName(String memoryName) {
        this.memoryName = memoryName;
    }
}
