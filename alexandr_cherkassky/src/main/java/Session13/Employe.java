package Session13;

import javax.persistence.*;

/**
 * Created by Пк2 on 13.02.2016.
 */
@Entity
@Table(name="Employe")
public class Employe {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "KHO_NOTES_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private  int id;

    @ManyToOne
    private Company workedAtCompany;

    public Employe(){

    }
    public Employe(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setCompany(Company aComp){
        this.workedAtCompany=aComp;
    }

}
