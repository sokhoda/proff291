package taxi.exception;

/**
 * Created by Юлия on 19.01.2016.
 */
public class ClientException extends Exception {

    public ClientException() {

    }

    public ClientException(String message) {
       super(message);
    }
    public String getMessage(){
        return  super.getMessage();
    }
}
