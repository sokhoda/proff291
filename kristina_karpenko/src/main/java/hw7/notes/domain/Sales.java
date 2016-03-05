package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static hw7.notes.util.Utils.DATEFORMAT_COMMON;

@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "SALES_SEQ", sequenceName = "SALES_SEQ", allocationSize = 1, initialValue = 500)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALES_SEQ")
    @Column(name = "SALES_ID")
    private Long id;

    @Column(name = "SALE_DATE")
    private Date date;

    @Column(name = "AMOUNT", length = 20)
    private Integer amount;

    @OneToMany(mappedBy = "sales")
    private Set<Store> stores = new HashSet<Store>();

    public Sales() {
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

    @Transient
    public String getDateStr() {
        if (date != null) {
            return DATEFORMAT_COMMON.get().format(date);
        }
        return "";
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    @Override
    public String toString() {
        return "Sales [" + "id=" + id + ", date=" + date + ", amount=" + amount + ']';
    }
}
