package session15;

/**
 * Created by Сергей on 20.02.2016.
 */
public class Company {
    private String nameCompany;
    private Director director;
    private Car car;

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public Company() {

    }

    public Company(String nameCompany, Director director, Car car) {
        this.nameCompany = nameCompany;
        this.director = director;
        this.car = car;
    }

}
