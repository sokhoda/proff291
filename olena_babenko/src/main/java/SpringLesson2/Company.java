package SpringLesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lenchi on 20.02.16.
 */
@Component("company1")
public class Company {
    @Value("companyName1")
    private String companyName;
    @Autowired(required = true)
    Director director = new Director();
    @Autowired(required = true)
    Car car = new Car();

    public Company(){

    }

    public Company(String companyName, Director director, Car car){
        this.companyName = companyName;
        this.director = director;
        this.car = car;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company {" +
                "companyName='" + companyName + '\'' +
                ", directorName ='"+director.getDirectorName()+'\''+
                ", carName ='"+car.getCarName()+'\''+
                '}';
    }
}