package laptopshop.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Pavel on 18.02.2016.
 */
public class Laptop {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sequence", sequenceName = "LAPTOP_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    Long id;

    @Column(name = "vendorId")
    Long vendorId;

    @Column(name = "model")
    String model;

    @Column(name = "produceDate")
    Date produceDate;

    @Column(name = "cpuId")
    Long cpuId;

    @Column(name = "memoryId")
    Long memoryId;
}
