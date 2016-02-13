package Notebooks.domain;

import javax.persistence.*;

/**
 * Created by User on 08.02.2016.
 */
@Entity
@Table(name = "NOTE")
public class Notebook {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;


    @Column(name = "NAME")
    private String model;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MANUFACTURE")
    private String manufacture;

    @Column(name = "PRICE")
    private Long price;


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long name) {
        this.id = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Notebook(Long id, String model, String vendor, String manufacture, Long price) {
        this.id = id;
        this.model = model;
        this.vendor = vendor;
        this.manufacture = manufacture;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;

        if (id != null ? !id.equals(notebook.id) : notebook.id != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + model + '\'' +
                '}';
    }
}
