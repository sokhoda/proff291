package hw7.notes.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "SALES_SEQ", sequenceName = "SALES_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALES_SEQ")
    @Column(name = "SALES_ID")
    private Long id;

    @Column(name = "SALE_DATE")
    private Date date;

    @Column(name = "AMOUNT", length = 20)
    private Integer amount;


    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    public Sales() {
    }

    public Sales(Store store, Integer amount) {
        this.amount = amount;
        this.store = store;
        date = new java.sql.Date(new java.util.Date().getTime());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Integer getAmount() {
        return amount;
    }

    public Store getStore() {
        return store;
    }

    @Override
    public String toString() {
        return "Sales [" + "id=" + id + ", date=" + date + ", amount=" + amount +
                "Store" +store.getNotebook().getStore().toString() +"   " + store.getPrice()+"]";
    }
}
