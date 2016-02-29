package hw7.springsnotes.domain;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "STORE")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORE_SEQ",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "NOTEBOOK_ID")
    private hw7.springsnotes.domain.Notebook notebook;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE")
    private Double price;

    private Double priseForOne;

    @OneToMany(mappedBy = "store", cascade = CascadeType.DETACH)
    private Set<hw7.springsnotes.domain.Sales> sales = new HashSet<>();

    public Store(){}

    public Store(Long id, hw7.springsnotes.domain.Notebook notebook, Integer quantity, Double price){
        this.id = id;
        this.notebook = notebook;
        this.quantity = quantity;
        this.price = price;
        this.priseForOne = price/quantity;
    }
    public Store(hw7.springsnotes.domain.Notebook notebook, Integer quantity, Double price){

        this.notebook = notebook;
        this.quantity = quantity;
        this.price = price;
        this.priseForOne = price/quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public hw7.springsnotes.domain.Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(hw7.springsnotes.domain.Notebook notebook) {
        this.notebook = notebook;
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

    public Set<hw7.springsnotes.domain.Sales> getSales() {
        return sales;
    }

    public void setSales(Set<hw7.springsnotes.domain.Sales> sales) {
        this.sales = sales;
    }

    public Double getPriseForOne() {
        return priseForOne;
    }

    public void setPriseForOne(Double priseForOne) {
        this.priseForOne = priseForOne;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", notebook=" + notebook +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
