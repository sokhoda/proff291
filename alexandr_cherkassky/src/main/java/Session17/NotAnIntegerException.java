package Session17;

/**
 * Created by Пк2 on 05.03.2016.
 */
public class NotAnIntegerException extends Exception {
    public NotAnIntegerException() {
        super("wrong input! Njt a nuber!");
    }

    public String getMessage(){
        return super.getMessage();
    }
}
