package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "BOOKS_SEQ", sequenceName = "BOOKS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKS_SEQ")
    @Column(name = "ID")
    public Long id;
    @Column(name = "SERIAL")
    private String serial;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "MODEL")
    private String model;
    @Temporal(TemporalType.DATE)
    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;
    @Column(name = "PRICE")
    private double price;
    public Notebook(){}
    public Notebook(String serial, String vendor, String model, Date manufactureDate, double price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public Notebook(Long id, String serial, String vendor, String model, Date manufactureDate, double price) {
        this.id = id;
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getSerial() {
        return serial;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return "NOTEBOOK{'\'"+" ID:"+id+"  SERIAL:"+serial+"  VENDOR:"+vendor+"  MODEL:"+model+" DATE:"+manufactureDate+"  PRICE:"+price+"}";
    }
}
