package session15;

/**
 * Created by Администратор on 20.02.2016.
 */
public class Car {


    private String name;

    public Car(){}

    public Car(String name) {
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
        return "Car{" +
                " name='" + name + '\'' +
                '}';
    }
}
