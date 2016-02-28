package hw8.taxi.exception;

/**
 * Created by Пк2 on 27.02.2016.
 */
public class OrderException extends Exception {
    public OrderException(String message){
        super(message);
    }

    public String getMessage(){
        return "OrderException"+super.getMessage();

    }

}
