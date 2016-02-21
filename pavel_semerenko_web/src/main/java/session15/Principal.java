package session15;

/**
 * Created by Pavel on 20.02.2016.
 */
public class Principal {
    Car car;
    String name;

    public Principal() {
    }

    public Principal(Car car) {
        this.car = car;
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
        return "Principal{" +
                "car=" + car +
                ", name='" + name + '\'' +
                '}';
    }
}
