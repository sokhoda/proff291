package web.hw9.taxi.exception;

/**
 * Created by Администратор on 11.03.2016.
 */
public class OrderException extends Exception {

    public OrderException(){}
    @Override
    public void printStackTrace() {
        new Exception("This login is already in use");
    }
}

