package hw7.notes.damain;

import javax.persistence.*;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @OneToOne
    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "id")
    @Column(name = "VENDOR_ID")
    private Vendor vendorMemory;


    @Column(name = "VOLUME")
    private Integer volume;

    public Memory (){}
    public Memory( Vendor vendorMemory, Integer volume){
        this.vendorMemory = vendorMemory;
        this.volume = volume;
    }

}
