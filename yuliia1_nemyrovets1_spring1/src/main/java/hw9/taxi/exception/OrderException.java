package hw9.taxi.exception;

/**
 * Created by Юлия on 02.03.2016.
 */
public class OrderException extends Exception {
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
