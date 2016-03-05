package session15;

import org.springframework.security.access.method.P;

/**
 * Created by Администратор on 20.02.2016.
 */
public class Director {

    private String name;
    private Phone phone;

    public Director() {
    }

    public Director(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                "phone" + phone +
                '}';
    }
}
