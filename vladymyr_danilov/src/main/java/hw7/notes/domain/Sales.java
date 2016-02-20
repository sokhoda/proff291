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
}
