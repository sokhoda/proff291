package Base25.week8.Calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TestProcessor extends AbstractProcessor implements CalcKeyMarks {
	// public TestProcessor() {
	// System.out.println("temp = " + getTemp() + ", result = " + getResult());
	// }
	private char				oper;
	private boolean				resetResult;

	private long				exp;
	private static final int	digits	= 10;

	private BigDecimal			secondOperand;
	private String				allZeros;
	private int					degRad;		// 0 - deg, 1-rad

	public TestProcessor() {
		super();
		this.secondOperand = new BigDecimal("0");
		exp = 0;
		oper = '\u0000';
		allZeros = "";
		degRad = 0;
	}

	@Override
	public void setResult(BigDecimal r) {
		// System.out.println("r.precision() = " + r.precision()
		// + ", r.scale() = " + r.scale());
		super.setResult(r.setScale(digits - (r.precision() - r.scale()),
				RoundingMode.CEILING).stripTrailingZeros());
	}

	public String res2String() {
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(0);
		int dig = (int) (Math.log10(getResult().doubleValue())) + 1;

		df.setMaximumFractionDigits(digits - dig);
		df.setGroupingUsed(false);
		return df.format(getResult());
	}

	@Override
	public void printResult(Object calcUIFX) {
		// System.out.println("Result = " + result);
		if (getAllZeros().length() == 0) {
			// System.out.println("Result: " + df.format(getResult()));
			((Displayable) calcUIFX).setDisplayFieldText(res2String());
			// return Double.parseDouble(df.format(val));
		}
		else {
			// System.out.println("Result: " + getAllZeros());
			((Displayable) calcUIFX).setDisplayFieldText(getAllZeros());
		}
	}

	@Override
	public void inputChar(char c) {
		String retValue = "";
		BigDecimal res = getResult();
		BigDecimal tmp = getTemp();
		// System.out.println("������� " + c);
		if ((c == '+') || (c == '-') || (c == '*') || (c == '/')
				|| (c == sciPadStartCode + 22)) {
			if (getOper() != '\u0000' && getOper() == c && getPrevChar() != '=') {
				if (c == '+') setResult(tmp.add(res));
				if (c == '-') setResult(tmp.subtract(res));
				if (c == '*') setResult(tmp.multiply(res));
				if (c == '/') setResult(tmp.divide(res, digits,
						RoundingMode.CEILING));
				if (c == sciPadStartCode + 22) setResult(tmp.remainder(res));
			}

			setTemp(getResult());
			setOper(c);
			setResetResult(true);
		}
		else if (c == '.') {
			setExp(1);
		}
		else if (c == '=') {
			if (getPrevChar() != '=') setSecondOperand(getResult());
			if (getPrevChar() == '=') {
				switch (getOper()) {
				case '+':
					setResult(res.add(secondOperand));
					break;
				case '-':
					setResult(res.subtract(secondOperand));
					break;
				case '*':
					setResult(res.multiply(secondOperand));
					break;
				case '/':
					if (secondOperand.compareTo(BigDecimal.ZERO) != 0) {
						setResult(res.divide(secondOperand, digits,
								RoundingMode.CEILING));
					}
					else setResult(BigDecimal.ZERO);
					break;
				}
			}
			else {
				switch (getOper()) {
				case '+':
					setResult(tmp.add(res));
					break;
				case '-':
					setResult(tmp.subtract(res));
					break;
				case '*':
					setResult(tmp.multiply(res));
					break;
				case '/':
					if (res.compareTo(BigDecimal.ZERO) != 0) {
						setResult(tmp.divide(res, digits, RoundingMode.CEILING));
					}
					else setResult(BigDecimal.ZERO);
					break;
				case (sciPadStartCode + 22):
					setResult(tmp.remainder(res));
				break;
				}
				// setOper('\u0000');
				setTemp(BigDecimal.ZERO);
			}
			setResetResult(true);
		}
		// backSpace
		else if (c == 8) {

			// double decPart = Math.abs(res.doubleValue() - res.intValue());
			BigDecimal decPart = res.subtract(
					new BigDecimal(res.toBigInteger())).abs();
			setExp(getExp() / 10);
			if (getExp() == 1) setExp(0);
			String s1 = res2String();

			if (decPart.compareTo(BigDecimal.ZERO) != 0) { // double
				setResult(new BigDecimal(String.valueOf(s1.substring(0,
						s1.length() - 1))));
				// setExp(getExp() / 10);
				// if (getExp() == 1) setExp(0);
			}
			else { // Integer
				setExp(0);
				if ((s1.length() == 1)
						|| (s1.length() == 2 && s1.charAt(0) == '-')) {
					setResult(BigDecimal.ZERO);
				}
				else setResult(new BigDecimal(String.valueOf(s1.substring(0,
						s1.length() - 1))));
			}
			setOper('\u0000');

		}

		// MS
		else if (c == startMemCode) {
			if (getResult().compareTo(BigDecimal.ZERO) != 0) setMem(getResult());
		}
		// MR
		else if (c == startMemCode + 1) {
			setResult(getMem());

			// setOper(' ');
			setResetResult(true);
		}
		// MC
		else if (c == startMemCode + 2) {
			setMem(BigDecimal.ZERO);
		}
		// M+
		else if (c == startMemCode + 3) {
			setMem(getMem().add(getResult()));
		}
		// M-
		else if (c == startMemCode + 4) {
			setMem(getMem().subtract(getResult()));
		}
		// C -all
		else if (c == 19) {
			setTemp(BigDecimal.ZERO); // new BigDecimal("0")
			setResult(BigDecimal.ZERO);
			setExp(0);
			setOper('\u0000');
			setAllZeros("");
		}
		// CE
		else if (c == 20) {
			setResult(BigDecimal.ZERO);
			setExp(0);
			setAllZeros("");
		}
		else if (c == operCodes[2]) { // 1/x
			setResult((BigDecimal.ONE).divide(getResult(), digits,
					RoundingMode.CEILING));
			setResetResult(true);
		}
		else if (c == operCodes[0]) { // +-
			if (!getResult().equals(BigDecimal.ZERO)) setResult(getResult()
					.negate());
		}
		else if ((c == operCodes[1])) { // x^0.5
			setResult(sqrt(getResult(), digits));
			setResetResult(true);
		}
		else if ((c == sciPadStartCode + 2)) { // Ln
			if (getResult().compareTo(BigDecimal.ZERO) < 0) {
				setAllZeros("Err");
			}
			else setResult(new BigDecimal(Math.log(getResult().doubleValue())));
			setResetResult(true);
		}
		else if (c == sciPadStartCode + 5) { // int
			setResult(new BigDecimal(getResult().toBigInteger()));
			setResetResult(true);
		}
		else if (c == sciPadStartCode + 8) { // x*x
			setResult(getResult().multiply(getResult()));
			setResetResult(true);
		}
		else if (c == sciPadStartCode + 15) { // pi
			setResult(new BigDecimal(Math.PI));
			setResetResult(true);
		}
		else if (c == sciPadStartCode + 18) { // x*x*x
			setResult(getResult().multiply(getResult()).multiply(getResult()));
			setResetResult(true);
		}
		else if ((c == sciPadStartCode + 19)) { // x^0.33
			setResult(cubeRoot(getResult(), digits));
			setResetResult(true);
		}
		else if ((c == sciPadStartCode + 23)) { // LOG
			if (getResult().compareTo(BigDecimal.ZERO) < 0) {
				setAllZeros("Err");
			}
			else setResult(new BigDecimal(Math.log10(getResult().doubleValue())));
			setResetResult(true);
		}
		else if ((c == sciPadStartCode + 24)) { // 10^x
			setResult(new BigDecimal(Math.pow(10, getResult().doubleValue())));
			setResetResult(true);
		}
		// trigonometry
		else if ((c == sciPadStartCode + 7)) { // sin
			double angle = getResult().doubleValue();
			if (degRad == 0) angle *= Math.PI / 180.;
			setResult(new BigDecimal(Math.sin(angle)));
			setResetResult(true);
		}
		else if ((c == sciPadStartCode + 12)) { // cos
			double angle = getResult().doubleValue();
			if (degRad == 0) angle *= Math.PI / 180.;
			setResult(new BigDecimal(Math.cos(angle)));
			setResetResult(true);
		}
		else if ((c == sciPadStartCode + 17)) { // tan
			double angle = getResult().doubleValue();
			if (degRad == 0) angle *= Math.PI / 180.;
			setResult(new BigDecimal(Math.tan(angle)));
			setResetResult(true);
		}
		// hyperbolic
		else if ((c == sciPadStartCode + 6)) { // sinh
			double angle = getResult().doubleValue();
			setResult(new BigDecimal(Math.sinh(angle)));
			setResetResult(true);
		}
		else if ((c == sciPadStartCode + 11)) { // cosh
			double angle = getResult().doubleValue();
			setResult(new BigDecimal(Math.cosh(angle)));
			setResetResult(true);
		}
		else if ((c == sciPadStartCode + 16)) { // tanh
			double angle = getResult().doubleValue();
			setResult(new BigDecimal(Math.tanh(angle)));
			setResetResult(true);
		}

		else if ((c >= 48) && (c <= 57)) {
			if (getResetResult()) {
				setResult(BigDecimal.ZERO);
				setExp(0);
				setResetResult(false);
			}

			BigDecimal res1 = getResult();
			BigDecimal bd1 = new BigDecimal(String.valueOf((c - '0')));
			if (res1.compareTo(BigDecimal.ZERO) < 0) bd1 = bd1.negate();

			if (getExp() > 0) {
				setExp(getExp() * 10);

				BigDecimal bd2 = new BigDecimal(String.valueOf(getExp()));
				// ��������� ������� �����
				BigDecimal decPart = res1.abs()
						.subtract(new BigDecimal(res1.toBigInteger())).abs();

				// (getResult().compareTo(BigDecimal.ZERO) == 0
				if (bd1.compareTo(BigDecimal.ZERO) == 0
						&& decPart.compareTo(BigDecimal.ZERO) == 0) {

					DecimalFormat df = new DecimalFormat("0");
					df.setMaximumFractionDigits(digits);

					String s1 = df.format(res1.toBigInteger().longValue()
							+ Math.pow(getExp(), -1));

					setAllZeros(s1.substring(0, s1.length() - 1) + "0");
				}
				else setAllZeros("");

				setResult(getResult().add(
						bd1.divide(bd2, digits, RoundingMode.CEILING)));
			}
			else setResult((getResult().multiply(BigDecimal.TEN)).add(bd1));

		}
	}

	public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
		BigDecimal x0 = new BigDecimal("0");
		BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
		while (!x0.equals(x1)) {
			x0 = x1;
			x1 = A.divide(x0, SCALE, RoundingMode.HALF_UP);
			x1 = x1.add(x0);
			x1 = x1.divide(BigDecimal.ONE.add(BigDecimal.ONE), SCALE,
					RoundingMode.HALF_UP);

		}
		return x1;
	}

	public static BigDecimal cubeRoot(BigDecimal A, final int SCALE) {
		BigDecimal x1 = new BigDecimal(Math.pow(A.doubleValue(), 1 / 3.));
		return x1;
	}

	public char getOper() {
		return oper;
	}

	public void setOper(char oper) {
		this.oper = oper;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public boolean getResetResult() {
		return resetResult;
	}

	public void setResetResult(boolean resetResult) {
		this.resetResult = resetResult;
	}

	public BigDecimal getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(BigDecimal secondOperand) {
		this.secondOperand = secondOperand;
	}

	public String getAllZeros() {
		return allZeros;
	}

	public void setAllZeros(String allZeros) {
		this.allZeros = allZeros;
	}

	public int getDegRad() {
		return degRad;
	}

	public void setDegRad(int degRad) {
		this.degRad = degRad;
	}

}