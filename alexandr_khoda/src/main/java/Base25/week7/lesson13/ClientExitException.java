package Base25.week7.lesson13;

public class ClientExitException extends Exception {

	public ClientExitException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "\nClientExitException:" + super.getMessage();
	}
}
