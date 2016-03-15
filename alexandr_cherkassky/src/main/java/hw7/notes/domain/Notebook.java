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
    @JoinColumn(name="VENDOR NAME")
    private Vendor noteVendor;

    @Column(name="NOTE MODEL")
    private String model;

    @Column(name="manuf_date")
    private Date manufDate;

    @ManyToOne
    @JoinColumn(name="NOTE CPU")
    private CPU noteCPU;

    @ManyToOne()
    @JoinColumn(name="NOTE MEMORY")
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
        this.cpuName=cpu.getCPUModel();
        this.noteMemory=memory;


    }



}
