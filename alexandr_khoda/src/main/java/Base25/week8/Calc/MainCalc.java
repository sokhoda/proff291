package Base25.week8.Calc;

import java.util.Locale;

public class MainCalc {

	public static void main(String[] args) {

		Locale EngLocale = new Locale("en", "UK");
		Locale.setDefault(EngLocale);
		AbstractProcessor processor = new TestProcessor();
		AbstractProcessor processor1 = new TestProcessor();
		CalcUI calcUI = new CalcUI();

		Calc calc = new Calc(processor, calcUI);
	}

}