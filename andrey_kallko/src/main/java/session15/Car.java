package session15;

/**
 * Created by elenabugercuk on 20.02.16.
 */
public class Car {
    private String name;
    private int number;


    public Car(){

    }

    public Car(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
