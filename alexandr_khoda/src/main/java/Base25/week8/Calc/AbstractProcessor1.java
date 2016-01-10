package Base25.week8.Calc;

import java.math.BigDecimal;

public abstract class AbstractProcessor1 implements Processorable {
	private BigDecimal	result;
	private BigDecimal	temp;

	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	// @Override
	// public void printResult() {
	// System.out.println("Result = " + result);
	// }

	protected void setResult(BigDecimal r) {
		result = r;
	}

	public BigDecimal getResult() {
		return result;

	}
}
