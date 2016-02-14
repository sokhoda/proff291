package hw7.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 14.02.2016.
 */
@Entity
@Table(name="MEMORIES")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORIES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private long id;

    @Column(name="SIZE")
    private int size;

    @OneToMany(mappedBy = "memory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Notebook> notebooks = new HashSet<>();

    public Memory(){
    }

    public Memory(int size) {
        this.size = size;
    }
}
