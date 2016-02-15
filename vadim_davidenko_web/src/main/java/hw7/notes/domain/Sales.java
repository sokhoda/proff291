package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вадим on 14.02.2016.
 *
 * склад ноутбуков, дата продажи, количество
 */

@Entity
@Table(name = "SALES")
@SequenceGenerator(name = "SALES_SEQ", sequenceName = "SALES_SEQ",
        allocationSize = 1, initialValue = 6000)

public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALES_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "QUANTITY", length = 20)
    private Integer quantity;

    @OneToMany(mappedBy = "sales")
    private Set<Store> stores = new HashSet<Store>();

    public Sales() {}

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}
