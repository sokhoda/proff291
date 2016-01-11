package Base25.week6.lesson12;

public class NullProductByDateException extends Exception {

	public NullProductByDateException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "\nNullProductByDateException:" + super.getMessage();

	}
}
