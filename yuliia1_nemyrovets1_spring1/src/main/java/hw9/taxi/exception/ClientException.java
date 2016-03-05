package hw9.taxi.exception;

/**
 * Created by Юлия on 02.03.2016.
 */
public class ClientException extends Exception {

    public ClientException() {
    }

    public ClientException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
