package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Юлия on 19.02.2016.
 */

@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SAL_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "SALES_ID")
    private Long id;

    @Column(name = "SALES_DATE")
    private Date date;

    @Column(name = "SALES_AMOUNT")
    private Integer amount;

    @OneToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;


    public Sales() {
    }

    public Sales(Date date, Integer amount) {
        this.date = date;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id+" "+ date+" "+amount;
    }
}