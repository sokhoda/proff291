package Session15;

/**
 * Created by Пк2 on 20.02.2016.
 */
public class Company {
    private String companyName;
    private CEO aCeo;
    private Car aCar;

    public Company(){}

    public Company(String companyName, CEO aCeo, Car aCar) {
        this.companyName = companyName;
        this.aCeo = aCeo;
        this.aCar = aCar;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CEO getaCeo() {
        return aCeo;
    }

    public void setaCeo(CEO aCeo) {
        this.aCeo = aCeo;
    }

    public Car getaCar() {
        return aCar;
    }

    public void setaCar(Car aCar) {
        this.aCar = aCar;
    }
}
