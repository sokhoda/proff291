package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import example.AbstractProcessor;

public class TestProcessor extends AbstractProcessor {
    public TestProcessor() {
    }

    public void inputChar(char c) {
        if(this.getResult() == this.getTemp()) {
            this.setResult(0);
        }

        System.out.println("Введено " + c);
        if(c != 43 && c != 45 && c != 47 && c != 42 && c != 61) {
            this.setResult(10 * this.getResult() + (c - 48));
        } else {
            this.action(c);
        }

    }
}
