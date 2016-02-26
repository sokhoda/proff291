package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SALES")
@SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALES_SEQ")
    @Column(name = "SALES_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STORE")
    private Store store;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "QUANTITY")
    private Integer quantity;

    public Sales() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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
}
