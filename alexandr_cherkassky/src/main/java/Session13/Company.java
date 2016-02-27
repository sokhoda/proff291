package Session13;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Пк2 on 13.02.2016.
 */
@Entity
@Table(name="Company")
public class Company {
    @Id
    private int id;
    @Column(name="company_name")
    private String company_Name;

    @Column( name="budget")
    @Convert(converter=MoneyConvereter.class)
    private Double budget;

    @OneToMany
    private Set<Employe> Employes;

    public Company(){

    }
    public Company(int id, String name, Double budget){
        this.id=id;
        this.company_Name=name;
        this.budget=budget;
        this.Employes=new HashSet<Employe>();
    }

    public Set<Employe> getEmployes(){
        return Employes;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        String str= "CompanyName: "+company_Name+" id: "+id+" Budget: "+budget;
        return str;
    }

    public Double getBudget() {
        return budget;
    }
     /*public String getName(){
        return company_Name;
    }

    public void setCompany_Name(String company_Name) {
        this.company_Name = company_Name;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public void setEmployes(Set<Employe> employes) {
        Employes = employes;
    }

    public void setId(int id) {
        this.id = id;
    }*/
}
