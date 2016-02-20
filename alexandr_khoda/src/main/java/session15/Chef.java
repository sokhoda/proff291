package session15;

/**
 * Created by s_okhoda on 20.02.2016.
 */
public class Chef {
    private String name;

    public Chef() {
    }

    public Chef(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "name='" + name +"}";
    }
}
