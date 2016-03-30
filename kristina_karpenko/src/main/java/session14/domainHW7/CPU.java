package session14.domainHW7;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вадим on 14.02.2016.
 *
 * производитель, частота, модель
 */

@Entity
@Table(name = "CPU")
@SequenceGenerator(name = "CPU_SEQ", sequenceName = "CPU_SEQ",
        allocationSize = 1, initialValue = 2001)

public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPU_SEQ")
    @Column(name = "CPU_ID")
    private Long id;

    @Column(name = "VENDOR", length = 50)
    private String vendor;

    @Column(name = "MODEL", length = 50)
    private String model;

    @Column(name = "FREQUENCY", length = 20)
    private String frequency;

    @OneToMany(mappedBy = "cpu")
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    public CPU() {}

    public CPU(String vendor, String model, String frequency) {
        this.vendor = vendor;
        this.model = model;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }
}
