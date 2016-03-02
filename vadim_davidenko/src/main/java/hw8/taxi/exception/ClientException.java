package hw8.taxi.exception;

/**
 * Created by v.davidenko on 29.01.2016.
 */
public class ClientException extends Exception {
    private String message;

    public ClientException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
