package hw7.notes.domain;

import javax.persistence.*;
import javax.swing.border.StrokeBorder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by s_okhoda on 16.02.2016.
 */
@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALE_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private Store store;
    private Date saleDate;
    private int quantity;

    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    public Sales(Store store, Date saleDate, int quantity) {
        this.store = store;
        this.saleDate = saleDate;
        this.quantity = quantity;
    }

    public Sales() {
    }

    @Override
    public String toString(){
        return "id=" + id + ", saleDate=" + df.format(saleDate) + ", " +
                "quantity=" + quantity;
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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
