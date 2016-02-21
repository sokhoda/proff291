package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STORE")
public class Store {
    @Id
    @SequenceGenerator(name = "STORE_SEQ", sequenceName = "STORE_SEQ", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_SEQ")
    @Column(name = "STORE_ID")
    private Long id;

    @Column(name = "AMOUNT", length = 20)
    private Integer amount;

    @Column(name = "PRICE", length = 20)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "NOTEBOOK_ID")
    private Notebook notebook;

    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Sales> sales = new HashSet<Sales>();

    public Store() {
    }

    public Store(Notebook notebook,Integer amount, Double price) {
        this.notebook = notebook;
        this.amount = amount;
        this.price = price;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getPrice() {
        return price;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    @Override
    public String toString() {
        return "Store[" + "id=" + id + ", amount=" + amount + ", price=" + price + "Notebook ID" + notebook.getId() + ']';
    }
}
