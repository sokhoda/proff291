package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Пк2 on 16.03.2016.
 */

@Entity
@Table(name="Sales")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Sales SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="Store_Id")
    private Store store;

    @Column(name="Sale_Date")
    private Date saleDate;

    @Column(name="Sale_Price")
    private Double price;

    public Sales(){}

    public Sales(Store store, Date date, Double price){
        this.store=store;
        this.saleDate=date;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", store=" + store.getId() +
                ", saleDate=" + saleDate +
                ", price=" + price +
                '}';
    }
}
