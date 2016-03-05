package hw7.notes.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "SALES")
public class Sales {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @Column(name = "SALES_DATE")
    private Date salesDate;

    @Column(name = "SALES_QUANTITY")
    private Integer salesQuantity;


    public Sales(){}

    public Sales(Store store, String date, Integer salesQuantity){

        this.store = store;
        this.salesDate = Date.valueOf(date);
        this.salesQuantity = salesQuantity;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", store=" + store +
                ", salesDate=" + salesDate +
                ", salesQuantity=" + salesQuantity +
                '}';
    }
}
