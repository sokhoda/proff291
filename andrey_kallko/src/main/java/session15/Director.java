package session15;

/**
 * Created by elenabugercuk on 20.02.16.
 */
public class Director {
    private String lastName;

    private Director(){

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Director{" +
                "lastName='" + lastName + '\'' +
                '}';
    }
}
