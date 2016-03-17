package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Пк2 on 20.02.2016.
 */
@Entity
@Table(name="Notebook")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Note SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="VENDOR ID")
    private Vendor noteVendor;

    @Column(name="NOTE MODEL")
    private String model;

    @Column(name="manuf_date")
    private Date manufDate;

    @ManyToOne
    @JoinColumn(name="NOTE CPU")
    private CPU noteCPU;

    @ManyToOne
    @JoinColumn(name="NOTE MEMORY")
    private Memory noteMemory;

    @OneToMany(mappedBy="note",cascade = CascadeType.ALL)
    private Set<Store> stores=new HashSet<>();


    @Column(name="vendor")
    private String vendName;

    @Column(name="cpu")
    private String cpuName;

    @Column(name="memory")
    private String memoryName;


    public Notebook(){}
    public Notebook(Vendor vendor, String model, Date manufDate, CPU cpu, Memory memory ){
        this.noteVendor=vendor;
        this.vendName=vendor.getVendorName();
        this.model=model;
        this.manufDate=manufDate;
        this.noteCPU=cpu;
        this.cpuName=cpu.getCPUModel();
        this.noteMemory=memory;


    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Date getManufDate() {
        return manufDate;
    }

    public CPU getNoteCPU() {
        return noteCPU;
    }

    public Memory getNoteMemory() {
        return noteMemory;
    }

    public String getVendName() {
        return vendName;
    }

    public String getCpuName() {
        return cpuName;
    }

    public String getMemoryName() {
        return memoryName;
    }

    public Vendor getNoteVendor() {
        return noteVendor;
    }

    public void setNoteVendor(Vendor noteVendor) {
        this.noteVendor = noteVendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufDate(Date manufDate) {
        this.manufDate = manufDate;
    }

    public void setNoteCPU(CPU noteCPU) {
        this.noteCPU = noteCPU;
    }

    public void setNoteMemory(Memory noteMemory) {
        this.noteMemory = noteMemory;
    }

    public void setVendName(String vendName) {
        this.vendName = vendName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public void setMemoryName(String memoryName) {
        this.memoryName = memoryName;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", noteVendor=" + noteVendor.getVendorName() +
                ", model='" + model + '\'' +
                ", manufDate=" + manufDate +
                ", noteCPU=" + noteCPU.getCPUModel() +
                ", noteMemory=" + noteMemory.getMemModel() +
                '}';
    }
}
