package hw7.notes.damain;

import javax.persistence.*;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VENDOR_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @OneToOne
    @Column(name = "ID")
    private Long id;


    @Column(name = "NAME")
    private String name;

    public Vendor(){}

    public Vendor(String name){
        this.name = name;
    }
}
