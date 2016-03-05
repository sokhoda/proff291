package SpringLesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lenchi on 20.02.16.
 */
@Component("director1")
public class Director {
    @Value("director1")
    private String directorName;

    @Autowired(required = true)
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
