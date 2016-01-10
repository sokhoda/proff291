package Base25.week8.lesson16;

import java.math.BigDecimal;

public class test {
	public static String dec2Bin(String decVal) {
		if (decVal.length() == 0) return "";
		int val = Integer.parseInt(decVal);
		if (val == 0) return "0";
		if (val == 1) return "1";

		String s = "";
		int quotient = val / 2;
		// System.out.println();
		s += val % 2;
		while (quotient >= 2) {
			s += quotient % 2;
			quotient = quotient / 2;
		}
		s += quotient;

		String s1 = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			s1 += Character.toString(s.charAt(i));
		}
		return s1;

	}

	public static void main(String[] args) {
		System.out.println(dec2Bin("10"));
		char c = 556;
		// char c1 = '\u0097';
		String c1 = "\u00B1";

		System.out.println(c1 + " \u2190 \u00F7 " + c);
		String s1 = "1000";
		BigDecimal bd = new BigDecimal(String.valueOf(s1.substring(0,
				s1.length() - 1)));
		System.out.println(bd);
		String g2 = "0";
		int b1 = 0;
		int b2 = ~b1;
		System.out.println(b1 + " " + b2 + " " + (~b2));
	}
}
