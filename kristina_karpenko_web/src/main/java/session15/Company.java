package session15;

/**
 * Created by Администратор on 20.02.2016.
 */
public class Company {

    private String name;
    private Director director;
    private Car car;

    public Company(String name, Director director, Car car) {
        this.name = name;
        this.director = director;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", car=" + car +
                '}';
    }
}
