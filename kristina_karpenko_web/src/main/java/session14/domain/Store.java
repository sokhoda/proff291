package session14.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kris on 15.02.2016.
 */
@Entity
@Table(name = "STORE")
public class Store {
    @Id
    @SequenceGenerator(name = "STORE_SEQ", sequenceName = "STORE_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_SEQ")
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "store")
    private Set<Notebook> notebooks = new HashSet<>();
    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "PRICE")
    private Double price;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Sales> sales = new HashSet<>();

    public Store() {
    }

    public Store(Long amount, Double price) {

        this.amount = amount;
        this.price = price;

    }

    public Store(Notebook notebook, Long amount, Double price) {
        notebooks.add(notebook);
        this.amount = amount;
        this.price = price;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNotebooks(Set<Notebook> notebook) {
        this.notebooks = notebook;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    public Long getId() {
        return id;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public Long getAmount() {
        return amount;
    }

    public Double getPrice() {
        return price;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void addNotebook(Notebook note) {
        notebooks.add(note);
    }

    public void addSales(Sales sale) {
        sales.add(sale);
    }
}