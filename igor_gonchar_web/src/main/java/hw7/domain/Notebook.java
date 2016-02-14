package hw7.domain;

import session14.Company;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Home on 14.02.2016.
 */

@Entity
@Table(name="NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name ="MODEL")
    private String model;

    @Column(name ="MANUFACTURE_DATE")
    private Date manufactureDate;

    @Column(name ="CPU")
    private String Cpu;

    @Column(name ="MEMORY")
    private int memory;

    public Notebook(){

    }
}
