package session15;

/**
 * Created by s_okhoda on 20.02.2016.
 */
public class Car {
    private String no;
    private String driver;

    public Car() {
    }


    public Car(String driver) {
        this.driver = driver;
    }


    public Car(String no, String driver) {
        this.no = no;
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Car{" +
                "no='" + no + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
