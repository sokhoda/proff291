package hw8.taxi.exception;

/**
 * Created by v.davidenko on 29.01.2016.
 */
public class OrderException extends Exception {
    private String message;

    public OrderException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
