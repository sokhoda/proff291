package Base25.week6.lesson11;

public class NotValidYearOfPurchase extends Exception {
	public NotValidYearOfPurchase(String message) {
		super(message);
	}

	public String getMeassage() {
		return "NotValidYearOfPurchase:" + super.getMessage();
	}
}
