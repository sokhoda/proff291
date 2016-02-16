package hw7.notes.domain;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by s_okhoda on 16.02.2016.
 */
@Entity
@Table (name = "STORE")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORE_SEQ",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    private Notebook ntb;
    private int quantity;
    private Double price;

    public Store(Long id, Notebook ntb, int quantity, Double price) {
        this.id = id;
        this.ntb = ntb;
        this.quantity = quantity;
        this.price = price;
    }

    public Store(Notebook ntb, int quantity, Double price) {
        this.ntb = ntb;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString(){
        return "id=" + id + ", ntb=" + ntb + ", quantity=" + quantity + ", " +
                "price=" + String.format("%.2f", price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notebook getNtb() {
        return ntb;
    }

    public void setNtb(Notebook ntb) {
        this.ntb = ntb;
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
