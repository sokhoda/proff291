package Notebooks.domain;

import javax.persistence.*;

/**
 * Created by User on 08.02.2016.
 */
@Entity
@Table(name="NOTE")
public class Notebook {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String model;


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


    public Notebook() {
    }

    public Notebook(Long name, String model) {
        this.id = name;
        this.model = model;
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
