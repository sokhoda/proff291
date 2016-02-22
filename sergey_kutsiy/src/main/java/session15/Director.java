package session15;

/**
 * Created by Сергей on 20.02.2016.
 */
public class Director {
    private String nameDirector;
    private Phone phone;
    private Car car;

    public String getNameDirector() {
        return nameDirector;
    }

    public void setNameDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Director() {

    }

    public Director(String nameDirector, Phone phone, Car car) {
        this.nameDirector = nameDirector;
        this.phone = phone;
        this.car = car;
    }


}
