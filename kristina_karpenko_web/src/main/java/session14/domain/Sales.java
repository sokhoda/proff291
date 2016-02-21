package session14.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kris on 15.02.2016.
 */
@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "SALES_SEQ", sequenceName = "SALES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALES_SEQ")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Store store;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "AMOUNT")
    private Long amount;

    public Sales() {
    }

    public Sales(Store store, Long amount, Date date) {
        this.amount = amount;
        this.store = store;
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }

    public Date getDate() {
        return date;
    }

    public Long getAmount() {
        return amount;
    }
}