package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ", allocationSize = 5, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @Column(name = "PRICE")
    private Double price;

    public Notebook(Long id, String serial, String vendor, String model, Date manufactureDate, Double price) {
        this.id = id;
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public Notebook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
