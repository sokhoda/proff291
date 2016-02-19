package web.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPANIES")
public class Company {
    @Id
    private String name;
    @Column
//    @Convert(converter = MoneyConverter.class)
    private Long money;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employer> employers;

    public Company(String name, Long money) {
        this.name = name;
        this.money = money;
        this.employers = new HashSet<>();
    }

    public Company() {
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Set<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(Employer employer) {
        this.employers.add(employer);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", employers=" + employers +
                '}';
    }
}
