package session15;

/**
 * Created by Pavel on 20.02.2016.
 */
public class Company {
    String name;
    Principal principal;

    public Company() {
    }

    public Company(Principal principal) {
        this.principal = principal;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", principal=" + principal +
                '}';
    }
}
