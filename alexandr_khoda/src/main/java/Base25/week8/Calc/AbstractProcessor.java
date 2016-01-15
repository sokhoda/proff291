package Base25.week8.Calc;

import java.math.BigDecimal;

public abstract class AbstractProcessor implements Processorable {
	private BigDecimal	result;

	private BigDecimal	temp;
	private BigDecimal	mem;
	private char		prevChar;

	public AbstractProcessor() {
		this.result = new BigDecimal("0");
		this.temp = new BigDecimal("0");
		this.mem = new BigDecimal("0");
		this.prevChar = '\u0000';
	}

	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	@Override
	public void printResult(Object calcImage) {
		// calcImage.setDisplayFieldText(result.toString());
		System.out.println("Result = " + result);
	}

	public void setResult(BigDecimal r) {
		result = r;
	}

	public BigDecimal getResult() {
		return result;
	}

	public BigDecimal getMem() {
		return mem;
	}

	public void setMem(BigDecimal mem) {
		this.mem = mem;
	}

	public char getPrevChar() {
		return prevChar;
	}

	public void setPrevChar(char prevChar) {
		this.prevChar = prevChar;
	}
}
