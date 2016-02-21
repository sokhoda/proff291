package hw7.notes.damain;


import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOK_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @OneToOne
    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "id")
    @Column(name = "VENDOR_ID")
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactoreDate;

    @OneToOne(mappedBy = "id")
    @Column(name = "CPU_ID")
    private CPU cpu;

    @OneToOne(mappedBy = "id")
    @Column(name = "MEMORY_ID")
    private Memory memory;

    public Notebook(){}
    public Notebook(Vendor vendor, String model, Date manufactoreDate, CPU cpu, Memory memory){
        this.vendor = vendor;
        this.model = model;
        this.manufactoreDate = manufactoreDate;
        this.cpu = cpu;
        this.memory = memory;
    }

}
