package session15;

/**
 * Created by s_okhoda on 20.02.2016.
 */
public class Company {
    private Chef chef;
    private Car car;

    public Company(Chef chef, Car car) {
        this.chef = chef;
        this.car = car;
    }

    public Company() {
    }

    public Company(Car car) {
        this.car = car;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
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
                "chef=" + chef +
                ", car=" + car +
                '}';
    }
}
