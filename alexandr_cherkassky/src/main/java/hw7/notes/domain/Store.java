package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Пк2 on 20.02.2016.
 */
@Entity
@Table(name="Stores")
public class Store {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Store SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="Store_Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="Notebook_Id")
    private Notebook note;

    @Column(name="Quantity")
    private Integer noteQuantity;

    @Column(name="Price")
    private Double price;

    @OneToMany(mappedBy="store",cascade = CascadeType.ALL)
    private Set<Sales> sales=new HashSet<>();

    public Store(){}

    public Store(Notebook note, Integer quantity,Double price){
        this.note=note;
        this.noteQuantity=quantity;
        this.price=price;

    }

    public Long getId() {
        return id;
    }

    public Notebook getNote() {
        return note;
    }

    public Integer getNoteQuantity() {
        return noteQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void setNote(Notebook note) {
        this.note = note;
    }

    public void setNoteQuantity(Integer noteQuantity) {
        this.noteQuantity = noteQuantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSales(Sales sale) {
        this.sales.add(sale);
    }

    public String toString(){
        return "{id: "+id+" note: "+note.getId()+" amount: "+getNoteQuantity()+" price: "+getPrice()+"}";
    }
}
