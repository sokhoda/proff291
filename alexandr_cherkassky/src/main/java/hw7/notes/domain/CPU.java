package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Пк2 on 20.02.2016.
 */
@Entity
@Table(name="CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "KHO_NOTES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private int id;

    @Column(name="cpu_name")
    private String cpuName;

    @OneToMany
    private Set<Notebook> thisCPUNotes=new HashSet<>();

    private CPU(){}
    private CPU(String cpuName){
        this.cpuName=cpuName;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }
}
