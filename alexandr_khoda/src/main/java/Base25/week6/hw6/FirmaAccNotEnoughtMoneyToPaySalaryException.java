package Base25.week6.hw6;

public class FirmaAccNotEnoughtMoneyToPaySalaryException extends Exception {

	public FirmaAccNotEnoughtMoneyToPaySalaryException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "\nFirmaAccNotEnoughtMoneyToPaySalary:" + super.getMessage();
	}
}
