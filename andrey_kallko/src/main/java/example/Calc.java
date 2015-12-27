package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import example.AbstractProcessor;

public class Calc {
    private static AbstractProcessor proc;

    public Calc(AbstractProcessor pr) {
        proc = pr;
    }

    public static void inSymv(char c) {
        proc.inputChar(c);
        proc.printResult();
    }
}
