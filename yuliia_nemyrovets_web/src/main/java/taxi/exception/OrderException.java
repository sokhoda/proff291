package taxi.exception;

import taxi.domain.Client;

/**
 * Created by Юлия on 19.01.2016.
 */
public class OrderException extends Exception {

    public OrderException() {

    }

    public OrderException(String message){
        super(message);
    }
    public String getMessage(){
        return  super.getMessage();
    }
}
