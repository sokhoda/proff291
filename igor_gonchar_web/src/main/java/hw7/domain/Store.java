package hw7.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 14.02.2016.
 */
@Entity
@Table(name="STRORE")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name="QUANTITY")
    private int amount;

    @Column(name="PRICE")
    private double price;

    @Column(name="TOTAL_PRICE")
    private double priceTotal;

    public Store(){

    }

    public Store(Notebook notebook, int amount, double price) {
        this.amount = amount;
        this.price = price;
        this.priceTotal = amount * price;
    }

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();

    @ManyToOne
    private Sales sales;

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }
}
