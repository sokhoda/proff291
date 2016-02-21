package laptopshop.domain;

import javax.persistence.*;

/**
 * Created by Pavel on 18.02.2016.
 */
public class CPU {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "vendorId")
    private Long vendorId;

    @Column(name = "frequency")
    Integer frequency;

    @Column(name = "model")
    String model;
}
