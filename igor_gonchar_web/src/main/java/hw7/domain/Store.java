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

    @ManyToOne
    private Notebook notebook;

    @Column(name="QUANTITY")
    private int amount;

    @Column(name="PRICE")
    private double price;

    public Store(){

    }

    public Store(Notebook notebook, int amount, double price) {
        this.notebook = notebook;
        this.amount = amount;
        this.price = price;
    }

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();

    @ManyToOne
    private Sales sales;
}
