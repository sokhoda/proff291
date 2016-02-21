package session15;

/**
 * Created by Solyk on 20.02.2016.
 */
public class Car {

    private  String nameOfCar;

    public  Car(){}

    public  Car(String nameOfCar){
        this.nameOfCar = nameOfCar;
    }

    public String getNameOfCar() {
        return nameOfCar;
    }

    public void setNameOfCar(String nameOfCar) {
        this.nameOfCar = nameOfCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nameOfCar='" + nameOfCar + '\'' +
                '}';
    }
}
