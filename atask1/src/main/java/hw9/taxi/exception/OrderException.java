package hw9.taxi.exception;

/**
 * Created by s_okhoda on 20.01.2016.
 */
public class OrderException extends  Exception{
    public OrderException(String message) {
        super(message);
    }

    public String getMessage(){
        return "OrderException: " + super.getMessage();
    }

}
