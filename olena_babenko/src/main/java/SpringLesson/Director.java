package SpringLesson;

/**
 * Created by lenchi on 20.02.16.
 */
public class Director {
    private String directorName;
    Car car = new Car();

    public Director(){

    }
    public Director(Car car){
        this.car = car;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public String toString() {
        return "Director {" +
                "directorName='" + directorName + '\'' +
                ", carName='"+car.getCarName()+'\''+
                '}';
    }
}
