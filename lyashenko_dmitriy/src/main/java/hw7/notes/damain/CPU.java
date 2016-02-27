package hw7.notes.damain;

import javax.persistence.*;

/**
 * Created by Solyk on 15.02.2016.
 */
@Entity
@Table(name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @OneToOne
    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "id")
    @Column(name = "VENDOR_ID")
    private Vendor vendor;

    @Column(name = "FREQUENCY")
    private Double frequency;

    @Column(name = "MODEL")
    private String model;

    public CPU(){}

    public CPU(Vendor vendor ,Double frequency, String model){
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }
}
