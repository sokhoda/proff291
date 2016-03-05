package session15;



/**
 * Created by elenabugercuk on 20.02.16.
 */
public class Company {
    private String name;
    private Director boss;
    private Car car;
    private Phone phone;

    public Company() {
    }

    public Director getBoss() {
        return boss;
    }

    public void setBoss(Director boss) {
        this.boss = boss;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company(String name, Director boss, Car car, Phone phone) {
        this.name = name;
        this.boss = boss;
        this.car = car;
        this.phone = phone;
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(Director boss) {
        this.boss = boss;
    }

    public Company(Car car) {
        this.car = car;
    }

    public Company(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", boss=" + boss +
                ", car=" + car +
                ", phone=" + phone +
                '}';
    }
}
