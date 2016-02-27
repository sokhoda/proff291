package Session15;

/**
 * Created by Пк2 on 20.02.2016.
 */
public class CEO {
    private String name;
    private Car aCar;

    public CEO(){}

    public CEO(Car thisCar, String name) {
        this.aCar = thisCar;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getaCar() {
        return aCar;
    }

    public void setaCar(Car aCar) {
        this.aCar = aCar;
    }

    @Override
    public String toString() {
        return "CEO{" +
                "name='" + name + '\'' +
                ", aCar=" + aCar +
                '}';
    }
}
