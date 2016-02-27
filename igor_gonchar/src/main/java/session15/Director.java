package session15;

/**
 * Created by Home on 20.02.2016.
 */
public class Director {
    private String name;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Director(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
