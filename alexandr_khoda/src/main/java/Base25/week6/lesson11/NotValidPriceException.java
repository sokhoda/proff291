package Base25.week6.lesson11;

public class NotValidPriceException extends Exception {

	public NotValidPriceException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "NotValidPriceException: " + super.getMessage();
	}

}
