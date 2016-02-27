package session15;

/**
 * Created by Solyk on 20.02.2016.
 */
public class Company {

    private String nameOfCompany;
    private Director directorOfCompany;
    private Car carOfCompany;

    public  Company(){}

    public Company(String nameOfCompany, Director directorOfCompany, Car carOfCompany){
        this.nameOfCompany = nameOfCompany;
        this.directorOfCompany = directorOfCompany;
        this.carOfCompany = carOfCompany;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public Director getDirectorOfCompany() {
        return directorOfCompany;
    }

    public void setDirectorOfCompany(Director directorOfCompany) {
        this.directorOfCompany = directorOfCompany;
    }

    public Car getCarOfCompany() {
        return carOfCompany;
    }

    public void setCarOfCompany(Car carOfCompany) {
        this.carOfCompany = carOfCompany;
    }

    @Override
    public String toString() {
        return "Company{" +
                "nameOfCompany='" + nameOfCompany + '\'' +
                ", directorOfCompany=" + directorOfCompany +
                ", carOfCompany=" + carOfCompany +
                '}';
    }
}
