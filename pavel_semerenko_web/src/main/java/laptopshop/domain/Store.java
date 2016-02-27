package laptopshop.domain;

import javax.persistence.*;

/**
 * Created by Pavel on 18.02.2016.
 */
@Entity(name = "STORES")
public class Store {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sequence", sequenceName = "STORES_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
}
