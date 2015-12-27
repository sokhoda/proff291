package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import example.Processorable;

public abstract class AbstractProcessor implements Processorable {
    private int result;
    private int temp = 0;
    private int operation = 43;

    public AbstractProcessor() {
    }

    public void printResult() {
        System.out.println("Result = " + this.result);
    }

    protected void setResult(int r) {
        this.result = r;
    }

    public int getResult() {
        return this.result;
    }

    protected void action(int newop) {
        if(this.operation == 43) {
            this.result += this.temp;
            this.temp = this.result;
        }

        if(this.operation == 45) {
            this.result = this.temp - this.result;
            this.temp = this.result;
        }

        if(this.operation == 47) {
            this.result = this.temp / this.result;
            this.temp = this.result;
        }

        if(this.operation == 42) {
            this.result = this.temp * this.result;
            this.temp = this.result;
        }

        if(this.operation == 61) {
            this.result = this.result;
            this.temp = this.result;
        }

        this.setOperation(newop);
    }

    public int getTemp() {
        return this.temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getOperation() {
        return this.operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}
