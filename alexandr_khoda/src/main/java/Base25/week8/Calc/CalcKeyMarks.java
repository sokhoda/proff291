package Base25.week8.Calc;

public interface CalcKeyMarks {
	public static final int		sciPadStartCode	= 550;
	public static final int		startMemCode	= 14;
	public static final char[]	operCodes		= { 501, 502, 503, 504 };
	String[][]					operPad			= { { "\u00B1", "\u221A" },
			{ "\u00F7", "\u00b9/x" }, { "\u00D7", "%" }, { "\u2212", "=" },
			{ "+", "+" }						};
	// /,1/x
	// *,%
	// -,=
	// +,+
	String[][]					sciPad			= {
			{ " ", "Inv", "ln", " ", " " },
			{ "Int", "sinh", "sin", "x\u00B2", "n!" },
			{ " ", "cosh", "cos", "x\u207F", " " },
			{ "\u03A0", "tanh", "tan", "x\u00B3", "\u221Bx" },
			{ " ", " ", "Mod", "log", "10\u207F" } };
	String[]					memPad			= { "MS", "MR", "MC", "M+",
	"M-"								};
	String[]					numericPad		= { "\u2190", "CE", "C", "1",
			"2", "3", "4", "5", "6", "7", "8", "9" };
	String[]					zeroPad			= { "0", "." };

	public default char transformChar(char c) {
		if (c == operPad[1][0].charAt(0)) return '/';
		if (c == operPad[2][0].charAt(0)) return '*';
		if (c == operPad[3][0].charAt(0)) return '-';
		if (c == operPad[0][0].charAt(0)) return operCodes[0]; // +-
		if (c == operPad[0][1].charAt(0)) return operCodes[1]; // sqrt
		if (c == operPad[1][1].charAt(0)) return operCodes[2]; // 1/x
		if (c == operPad[2][1].charAt(0)) return operCodes[3]; // %
		return c;
	}
}
