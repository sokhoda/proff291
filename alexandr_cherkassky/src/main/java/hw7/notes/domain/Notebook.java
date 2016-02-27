package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

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
    @JoinColumn(name="vendor_name")
    private Vendor noteVendor;

    @Column(name="model")
    private String model;

    @Column(name="manuf_date")
    private Date manufDate;

    @ManyToOne
    private CPU noteCPU;

    @ManyToOne
    private Memory noteMemory;

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
        this.cpuName=cpu.getCpuName();
        this.noteMemory=memory;
        this.memoryName=memory.getMemoryName();

    }



}
