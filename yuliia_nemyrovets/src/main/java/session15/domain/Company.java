package session15.domain;

/**
 * Created by Юлия on 20.02.2016.
 */
public class Company {
    private String name;
    private Ditector director;
    private Car car;

    public Company() {
    }

    public Company(String name, Ditector director, Car car) {
        this.name = name;
        this.director = director;
        this.car = car;
    }

    public Ditector getDirector() {
        return director;
    }

    public void setDirector(Ditector director) {
        this.director = director;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", car=" + car +
                '}';
    }
}
