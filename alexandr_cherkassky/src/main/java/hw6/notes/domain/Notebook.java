package hw6.notes.domain;




import javax.persistence.*;
import java.util.Date;
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


    private Long id;

    @Column(name="SERIAL")
    private String serial=null;

    @Column(name="VENDOR")
    private String vendor=null;

    @Column(name="MODEL")
    private String model=null;

    @Column(name="MANUFACTURE DATE")
    private Date manufDate;

    @Column(name="PRICE")
    private Double price=null;

    public Notebook(){

    }

    public Notebook( String serial, String vendor, String model,Date manufDate, Double price) {
        this.id = id;
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufDate = manufDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", serial=" + serial +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
               /* ", manufDate=" + manufDate +*/
                ", price=" + price +
                '}';
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

    public Date getManufDate() {
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

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufDate(Date manufDate) {
        this.manufDate = manufDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
