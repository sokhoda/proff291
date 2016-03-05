package hw6.notes.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Pavel on 10.02.2016.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    Long id;

    @Column(name = "serial")
    String serial;

    @Column(name = "vendor")
    String vendor;

    @Column(name = "model")
    String model;

    @Column(name = "manufacture_date")
    Date manufacture_date;

    @Column(name = "price")
    float price;

    public Notebook() {
    }

    public Notebook(String serial, String vendor, String model, Date manufacture_date, float price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufacture_date = manufacture_date;
        this.price = price;
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

    public Date getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", manufacture_date=" + manufacture_date +
                ", price=" + price +
                '}';
    }
}
