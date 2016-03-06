package example;

import javax.persistence.*;


@Entity
@Table(name = "USERS")
public class Example {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    public Example(String name) {
        this.name = name;
    }

    public Example(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


