package hw9.taxi.exception;

/**
 * Created by Администратор on 01.03.2016.
 */
public class AuthenticationException extends Exception {
    AuthenticationException(){}

    @Override
    public void printStackTrace() {
        new Exception("This login is already in use");
    }
}
