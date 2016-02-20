package hw7.notes.domain;

import javax.persistence.*;
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
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private Long storeId;
    private Date saleDate;
    private int quantity;

    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    public Sales(Long storeId, Date saleDate, int quantity) {
        this.storeId = storeId;
        this.saleDate = saleDate;
        this.quantity = quantity;
    }

    public Sales() {
    }

    @Override
    public String toString(){
        return "id=" + id + ", storeId=" + storeId + ", saleDate=" + df.format
                (saleDate) +", quantity=" + quantity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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
