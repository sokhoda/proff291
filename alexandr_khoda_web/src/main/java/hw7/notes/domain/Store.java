package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by s_okhoda on 16.02.2016.
 */
@Entity
@Table (name = "STORE")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORE_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    private Long ntbId;
    private int quantity;
    private Double price;

    public Store(Long id, Long ntbId, int quantity, Double price) {
        this.id = id;
        this.ntbId = ntbId;
        this.quantity = quantity;
        this.price = price;
    }

    public Store(Notebook ntb, int quantity, Double price) {
        this.ntbId = ntbId;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString(){
        return "id=" + id + ", ntbId=" + ntbId + ", quantity=" + quantity + ", " +
                "price=" + String.format("%.2f", price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNtbId() {
        return ntbId;
    }

    public void setNtbId(Long ntbId) {
        this.ntbId = ntbId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
