package NotebookShop;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "NOTEBOOKSLIST")
public class notebookslist {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "REGIONS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufacture_date;

    @Column(name = "PRICE")
    private Double price;

    notebookslist() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return "ID " + id + "  SERIAL " + serial + "  VENDOR " + vendor + "  MODEL " + model + " MANUFACTURE DATE " + manufacture_date + "  PRICE " + price;
    }
}
