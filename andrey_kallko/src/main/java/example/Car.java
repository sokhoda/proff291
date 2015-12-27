package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import example.Engine;
import java.io.Serializable;

public class Car implements Cloneable, Serializable {
    private int number;
    private Engine engine;

    public Car() {
    }

    public Car(int number) {
        this.number = number;
    }

    public Car(int number, int eNumber) {
        this.number = number;
        this.engine = new Engine();
        this.engine.setNumber(eNumber);
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car clone() throws CloneNotSupportedException {
        Car car1 = (Car)super.clone();
        Engine e1 = this.getEngine().clone();
        car1.setEngine(e1);
        return car1;
    }
}
