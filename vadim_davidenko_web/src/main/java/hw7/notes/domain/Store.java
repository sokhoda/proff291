package hw7.notes.domain;

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
        allocationSize = 1, initialValue = 5000)

public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUANTITY", length = 20)
    private Integer quantity;

    @Column(name = "PRICE", length = 20)
    private Double price;

    @OneToMany(mappedBy = "store")
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    @ManyToOne
    @Column(name = "SALES", length = 20)
    private Sales sales;

    public Store() {}

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
