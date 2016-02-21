package hw7.notes.damain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "SALES")
public class Sales {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "id")
    @Column(name = "STORE_ID")
    private Store store;

    @Column(name = "SALES_DATE")
    private Date salesDate;

    @Column(name = "SALES_QUANTITY")
    private Integer salesQuantity;

    public Sales(){}

    public Sales(Store store, Date salesDate, Integer salesQuantity){

        this.store = store;
        this.salesDate = salesDate;
        this.salesQuantity = salesQuantity;


    }

}
