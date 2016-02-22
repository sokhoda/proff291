package hw7.notes.damain;

import javax.persistence.*;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "STORE")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @OneToOne
    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "id")
    @Column(name = "NOTEBOOK_ID")
    private Notebook notebook;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE")
    private Double price;

    public Store(){}

    public Store(Long id, Notebook notebook, Integer quantity, Double price){

        this.id = id;
        this.notebook = notebook;
        this.quantity = quantity;
        this.price = price;
    }
    public Store( Notebook notebook, Integer quantity, Double price){

        this.notebook = notebook;
        this.quantity = quantity;
        this.price = price;
    }
}
