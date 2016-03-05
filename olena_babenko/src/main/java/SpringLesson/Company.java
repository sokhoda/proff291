package SpringLesson;

/**
 * Created by lenchi on 20.02.16.
 */
public class Company {
    private String companyName;
    Director director = new Director();
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