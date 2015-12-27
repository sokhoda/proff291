package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */

import java.io.Serializable;

public class Engine implements Cloneable, Serializable {
    private int number;

    public Engine() {
    }

    public Engine(int number) {
        this.number = number;
    }

    public Engine clone() throws CloneNotSupportedException {
        return (Engine)super.clone();
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
