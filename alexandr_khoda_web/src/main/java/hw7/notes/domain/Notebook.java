package hw7.notes.domain;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by s_okhoda on 09.02.2016.
 */
@Entity
@Table(name = "NOTES7")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTES7_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name="VENDOR")
    private Vendor vendor;

    @Column(name="MODEL")
    private String model;

    @Column(name="MANDATE")
    private Date manDate;
    private CPU cpu;
    private Memory memory;

    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    public Notebook(){
    }

    public Notebook(Vendor vendor, String model, Date manDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manDate = manDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Notebook(Vendor vendor, String model, Date manDate) {
        this(vendor, model, manDate, null, null);

    }

    @Override
    public String toString(){
        return "id=" + id + ", vendor=" + vendor.getName() + ", model=" +
                model + ", manDate=" + df.format(manDate) + ", cpu=" + cpu.toString() +
                ", memory=" + memory.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManDate() {
        return manDate;
    }

    public void setManDate(Date manDate) {
        this.manDate = manDate;
    }

    public void setId(Long id) {
        this.id = id;
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
}
