package Base25.week8.Calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcEngine implements ActionListener {
	private CalcUI	calcUI;

	public CalcEngine(CalcUI calcUI) {
		this.calcUI = calcUI;
	}

	public void inSymv(char c) {
		calcUI.getCalc().getProc().inputChar(c);
		calcUI.getCalc().getProc().printResult(calcUI);
		calcUI.getCalc().getProc().setPrevChar(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == calcUI.getButtonPlus()) {
			inSymv('+');
		}
		else if (src == calcUI.getButtonMinus()) {
			inSymv('-');
		}
		else if (src == calcUI.getButtonDivide()) {
			inSymv('/');
		}
		else if (src == calcUI.getButtonMultiply()) {
			inSymv('*');
		}
		else if (src == calcUI.getButtonEquals()) {
			inSymv('=');
		}
		else if (src == calcUI.getButtonPoint()) {
			inSymv('.');
		}
		else if (src == calcUI.getButtonBackSpace()) {
			inSymv((char) (8));
		}
		else if (src == calcUI.getButton0()) {
			inSymv('0');
		}
		else if (src == calcUI.getButton1()) {
			inSymv('1');
		}
		else if (src == calcUI.getButton2()) {
			inSymv('2');
		}
		else if (src == calcUI.getButton3()) {
			inSymv('3');
		}
		else if (src == calcUI.getButton4()) {
			inSymv('4');
		}
		else if (src == calcUI.getButton5()) {
			inSymv('5');
		}
		else if (src == calcUI.getButton6()) {
			inSymv('6');
		}
		else if (src == calcUI.getButton7()) {
			inSymv('7');
		}
		else if (src == calcUI.getButton8()) {
			inSymv('8');
		}
		else if (src == calcUI.getButton9()) {
			inSymv('9');
		}
		else if (src == calcUI.getButtonC()) {
			inSymv((char) (19));
		}
		else if (src == calcUI.getButtonCE()) {
			inSymv((char) (20));
		}
		else if (src == calcUI.getButtonMemSave()) {
			inSymv((char) (14));
		}
		else if (src == calcUI.getButtonMemRead()) {
			inSymv((char) (15));
		}
		else if (src == calcUI.getButtonMemClear()) {
			inSymv((char) (16));
		}
		else if (src == calcUI.getButtonMemPlus()) {
			inSymv((char) (17));
		}
		else if (src == calcUI.getButtonMemMinus()) {
			inSymv((char) (18));
		}
		else if (src == calcUI.getButtonExit()) {
			System.exit(1);
		}

		// if (getSrc instanceof JButton) {
		// btn = (JButton) getSrc;
		// text1 = btn.getLabel();
		// }
		// else if (getSrc instanceof JTextField) {
		// myDisplayField = (JTextField) getSrc;
		// text1 = myDisplayField.getText();
		// }
		// else text1 = "";
		//
		// JOptionPane.showConfirmDialog(null, "Happen to greet you!",
		// "Greetings, button " + text1, JOptionPane.PLAIN_MESSAGE);

	}
}
