package web.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "EMPLOYERS")
public class Employer {
    @Id
    private Integer id;
    @ManyToOne
    private Company company;

    public Employer(Integer id) {
        this.id = id;
    }

    public Employer() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", company=" + company +
                '}';
    }
}
