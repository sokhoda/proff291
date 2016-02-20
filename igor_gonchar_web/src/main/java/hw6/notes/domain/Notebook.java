package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by i.gonchar on 2/10/2016.
 */
@Entity
@Table(name = "NOTES")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "SERIAL")
    private long serial;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @Column(name = "PRICE")
    private int price;


    public Notebook() {

    }

    public Notebook(long serial, String vendor, String model, int price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        //this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public Notebook(long serial, String vendor, String model, Date manufactureDate, int price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;


        if (serial != notebook.serial) return false;
        if (!vendor.equals(notebook.vendor)) return false;
        return model.equals(notebook.model);

    }


    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", login=" + serial +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", price=" + price +
                '}';
    }

    public long getId() {
        return id;
    }

    public long getSerial() {
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

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSerial(long serial) {
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

    public void setPrice(int price) {
        this.price = price;
    }


}
