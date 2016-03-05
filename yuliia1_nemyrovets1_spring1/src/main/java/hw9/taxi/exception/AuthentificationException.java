package hw9.taxi.exception;

/**
 * Created by Юлия on 02.03.2016.
 */
public class AuthentificationException extends Exception {
    public AuthentificationException() {
    }

    public AuthentificationException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
