package Base25.week6.lesson12;

public class NullProductByCodeException extends Exception {

	public NullProductByCodeException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "\nNullProductByCodeException:" + super.getMessage();
	}
}
