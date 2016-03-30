package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STORE")
public class Store {
    @Id
    @SequenceGenerator(name = "STORE_SEQ", sequenceName = "STORE_SEQ", allocationSize = 1, initialValue = 600)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_SEQ")
    @Column(name = "STORE_ID")
    private Long id;

    @Column(name = "AMOUNT", length = 20)
    private Integer amount;

    @Column(name = "PRICE", length = 20)
    private Double price;

    @OneToMany(mappedBy = "store")
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    @ManyToOne
    @JoinColumn(name = "SALES_ID")
    private Sales sales;

    public Store() {
    }

    public Store(Integer amount, Double price) {
        this.amount = amount;
        this.price = price;

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

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Store[" + "id=" + id + ", amount=" + amount + ", price=" + price + ']';
    }
}
