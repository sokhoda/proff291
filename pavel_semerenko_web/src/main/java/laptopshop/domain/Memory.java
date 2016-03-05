package laptopshop.domain;

import javax.persistence.*;

/**
 * Created by Pavel on 18.02.2016.
 */
@Entity(name = "MEMORYS")
public class Memory {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    Long id;

    @Column(name = "vendorId")
    Long vendorId;

    @Column(name = "size")
    Integer size;
}
