package Session15;

/**
 * Created by Пк2 on 20.02.2016.
 */
public class Car {
    private String carName;
    //private CEO aCeo;

    public Car() {}

    public Car(String carName/*, CEO aCeo*/) {
        this.carName = carName;
        //this.aCeo = aCeo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                '}';
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

//    public CEO getaCeo() {
//        return aCeo;
//    }

//    public void setaCeo(CEO aCeo) {
//        this.aCeo = aCeo;
//    }
}
