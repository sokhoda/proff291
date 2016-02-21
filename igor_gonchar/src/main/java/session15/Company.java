package session15;

/**
 * Created by Home on 20.02.2016.
 */
public class Company {
    private String name;
    private Car car;
    private Director director;

    public Company(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
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
                ", car=" + car +
                ", director=" + director +
                '}';
    }
}
