package hw6.notes.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Solyk on 08.02.2016.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "SERIALS")
    private String serialNumber;

    @Column(name = "VENDORS")
    private String vendor;

    @Column(name = "MODELS")
    private String model;

    @Column(name = "MANUFACTURE_DATES")
    private Date manufactureDate;

    @Column(name = "PRISES")
    private Double prise;

    public Notebook(){}

    public Notebook(String serialNumber, String vendor, String model, int year, int mounth, int day, Double prise){
        this.serialNumber = serialNumber;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = Date.valueOf(year + "-" + mounth + "-" + day);
        this.prise = prise;
    }


}
