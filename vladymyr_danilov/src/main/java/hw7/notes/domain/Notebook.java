package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTEBOOK")
@SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOK_SEQ")
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTEBOOK_SEQ")
    @Column(name = "NOTEBOOK_ID")
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @ManyToOne
    @JoinColumn(name = "VENDOR")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "CPU")
    private CPU cpu;

    @ManyToOne
    @JoinColumn(name = "MEMORY")
    private Memory memory;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    public Notebook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", vendor=" + vendor +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", manufactureDate=" + manufactureDate +
                '}';
    }
}
