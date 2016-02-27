package session15;

/**
 * Created by Solyk on 20.02.2016.
 */
public class Director {

    private String nameOfDirector;

    public Director(){}

    public  Director(String nameOfDirector){
        this.nameOfDirector = nameOfDirector;
    }

    public String getNameOfDirector() {
        return nameOfDirector;
    }

    public void setNameOfDirector(String nameOfDirector) {
        this.nameOfDirector = nameOfDirector;
    }

    @Override
    public String toString() {
        return "Director{" +
                "nameOfDirector='" + nameOfDirector + '\'' +
                '}';
    }
}
