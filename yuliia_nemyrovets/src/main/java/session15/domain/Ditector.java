package session15.domain;

import org.springframework.security.access.method.P;

/**
 * Created by Юлия on 20.02.2016.
 */
public class Ditector {
    private String name;
    private Phone phone;

    public Ditector() {
    }

    public Ditector(Phone phone, String name) {
        this.phone = phone;
        this.name = name;
       }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "Ditector{" +
                "name='" + name + '\'' +
                               ", phone=" + phone +
                '}';
    }
}
