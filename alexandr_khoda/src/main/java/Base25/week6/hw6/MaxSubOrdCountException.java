package Base25.week6.hw6;

public class MaxSubOrdCountException extends Exception {

	public MaxSubOrdCountException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "\nMaxSubOrdCountException:" + super.getMessage();
	}

}
