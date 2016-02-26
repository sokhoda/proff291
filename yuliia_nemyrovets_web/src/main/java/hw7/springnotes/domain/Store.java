package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Юлия on 19.02.2016.
 */

@Entity
@Table(name = "STORES")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ST_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "STORE_ID")
    private Long id;

    @Column(name = "STORE_AMOUNT")
    private Integer amount;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "NOTEBOOK_ID")
    private Notebook notebook;

    @OneToOne(mappedBy = "STORE", cascade = CascadeType.DETACH)
    private Sales sales;

    public Store() {
    }

    public Store(Integer amount) {
        this.amount = amount;
    }


    public Store(Notebook notebook, Integer amount, Double price) {
        this.amount = amount;
        this.notebook = notebook;
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

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id+" "+amount+" "+ price;
    }
}
