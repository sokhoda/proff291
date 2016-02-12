package hw6.notes.domain;

import hw6.notes.util.Utils;

import javax.persistence.*;
import java.util.Date;

import static hw6.notes.util.Utils.DATEFORMAT_COMMON;

/**
 * Created by Вадим on 07.02.2016.
 *
 */

@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "NOTEBOOKS_SEQ", sequenceName = "NOTEBOOKS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTEBOOKS_SEQ")

    @Column(name = "ID")
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

    public Notebook(String serial, Double price, String vendor, String model, Date manufactureDate) {
        this.serial = serial;
        this.price = price;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
    }

    public Notebook() {}

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", vendor='" + vendor + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", price=" + price +
                '}';
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

    @Transient
    public String getManufactureDateStr() {
        if (manufactureDate != null) {
            return DATEFORMAT_COMMON.get().format(manufactureDate);
        }
        return "";
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
