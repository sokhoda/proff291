package hw6.notes.domain;




import javax.persistence.*;
import java.util.GregorianCalendar;

/**
 * Created by Пк2 on 09.02.2016.
 */
@Entity
@Table(name="Notebook")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "KHO_NOTES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")


    private Long id=null;

    @Column(name="SERIAL")
    private Long serial=null;

    @Column(name="VENDOR")
    private String vendor=null;

    @Column(name="MODEL")
    private String model=null;

    @Column(name="MANUFACTURE DATE")
    private GregorianCalendar manufDate;

    @Column(name="PRICE")
    private Double price=null;

    public Notebook(Long id, Long serial, String vendor, String model, GregorianCalendar manufDate, Double price) {
        this.id = id;
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufDate = manufDate;
        this.price = price;
    }

    public Notebook(Long id,String model, Double price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", serial=" + serial +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", manufDate=" + manufDate +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getSerial() {
        return serial;
    }

    public String getVendor() {
        return vendor;
    }

    public GregorianCalendar getManufDate() {
        return manufDate;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufDate(GregorianCalendar manufDate) {
        this.manufDate = manufDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
