package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Юлия on 19.02.2016.
 */

@Entity
@Table(name = "STORES")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ST_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "STORE_ID")
    private Long id;

    @Column(name = "STORE_AMOUNT")
    private Integer amount;

    @Column(name = "PRICE")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "NOTEBOOK_ID")
    private Notebook notebook;

    @OneToMany(mappedBy = "STORE", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Sales> sales = new HashSet<>();

    public Store() {
    }

    public Store(Integer amount, Double price, Notebook notebook) {
        this.amount = amount;
        this.price = price;
        this.notebook = notebook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }
}
