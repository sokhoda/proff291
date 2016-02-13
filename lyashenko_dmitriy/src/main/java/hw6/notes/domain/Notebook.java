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
    private Date manufactoreDate;

    @Column(name = "PRICES")
    private Double price;

    public Notebook(String serialNumber,String vendor, String model, int year, int mounth, int day, Double price){
        this.serialNumber = serialNumber;
        this.vendor = vendor;
        this.model = model;
        this.manufactoreDate = Date.valueOf(year + "-" +  mounth +  "-" + day);
        this.price = price;
    }

    public Notebook(){}

    @Override
    public String toString() {
        return id + " " + serialNumber + " " + vendor + " " + model + " " + manufactoreDate + " " + price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public Date getManufactoreDate() {
        return manufactoreDate;
    }

    public void setManufactoreDate(Date manufactoreDate) {
        this.manufactoreDate = manufactoreDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
