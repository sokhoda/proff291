package laptopshop.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Pavel on 18.02.2016.
 */
@Entity(name = "LAPTOPS")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
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
}
