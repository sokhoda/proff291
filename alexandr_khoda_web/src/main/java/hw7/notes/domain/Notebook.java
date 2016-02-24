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

    private Long vendorId;

    @Column(name="MODEL")
    private String model;

    @Column(name="MANDATE")
    private Date manDate;
    private Long cpuId;
    private Long memoryId;

    @Transient
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    public Notebook(){
    }

    public Notebook(Long vendorId, String model, Date manDate, Long cpuId,
                    Long memoryId) {
        this.vendorId = vendorId;
        this.model = model;
        this.manDate = manDate;
        this.cpuId = cpuId;
        this.memoryId = memoryId;
    }

    public Notebook(Long vendorId, String model, Date manDate) {
        this(vendorId, model, manDate, null, null);

    }

    @Override
    public String toString(){
        return "id=" + id + ", vendorId=" + vendorId + ", model=" +
                model + ", manDate=" + df.format(manDate) + ", cpuId=" + cpuId +
                ", memoryId=" + memoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getCpuId() {
        return cpuId;
    }

    public void setCpuId(Long cpuId) {
        this.cpuId = cpuId;
    }

    public Long getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(Long memoryId) {
        this.memoryId = memoryId;
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

}
