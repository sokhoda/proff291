package hw7.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 14.02.2016.
 */
@Entity
@Table(name="SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Store> stores = new HashSet<>();

    @Column(name="SALES_DATE")
    private Date date;

    @Column(name="AMOUNT")
    private int amount;

    public Sales(){

    }

    public Sales(Date date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public long getId() {
        return id;
    }
}
