package session14.domainHW7;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вадим on 14.02.2016.
 *
 * тип ноутбука, количество, цена
 */

@Entity
@Table(name = "STORE")
@SequenceGenerator(name = "STORE_SEQ", sequenceName = "STORE_SEQ",
        allocationSize = 1, initialValue = 5001)

public class Store {
    @Id
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

    public Store() {}

    public Store(Integer amount, Double price) {
        this.amount = amount;
        this.price = price;

    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                '}';
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
}
