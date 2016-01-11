package Base25.week8.Calc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcUI implements Displayable, CalcKeyMarks {
	// Declare all calculator�s components.
	private JPanel		windowContent;
	private JTextField	displayField;
	private JButton		button0;
	private JButton		button1;
	private JButton		button2;
	private JButton		button3;
	private JButton		button4;
	private JButton		button5;
	private JButton		button6;
	private JButton		button7;
	private JButton		button8;
	private JButton		button9;
	private JButton		buttonPoint;
	private JButton		buttonEquals;

	private JButton		buttonPlus;
	private JButton		buttonMinus;
	private JButton		buttonMultiply;
	private JButton		buttonDivide;
	private JButton		buttonC;
	private JButton		buttonCE;

	private JButton		buttonBackSpace;
	private JButton		buttonMemSave;
	private JButton		buttonMemRead;
	private JButton		buttonMemClear;
	private JButton		buttonMemPlus;
	private JButton		buttonMemMinus;

	private JButton		button1x;
	private JButton		buttonX2;
	private JButton		buttonX3;
	private JButton		buttonPowXY;
	private JButton		buttonLog;
	private JButton		buttonLn;
	private JButton		buttonSqrt;
	private JButton		buttonSin;
	private JButton		buttonCos;
	private JButton		buttonTan;
	private JButton		buttonPI;

	private JButton		buttonExit;

	JPanel				numPan, p2, MemPanel, operPanel, auxRightPanel,
			contrPan, auxControl;
	private Calc		calc;
	CalcEngine			calcEngine	= new CalcEngine(this);

	// Constructor creates the components
	// and adds the to the frame using combination of
	// Borderlayout and Gridlayout
	CalcUI() {

		windowContent = new JPanel();
		windowContent.setLayout(new BorderLayout());

		// Create the display field and place it in the
		// North area of the window
		displayField = new JTextField(30);
		Font font1 = new Font("SansSerif", Font.BOLD, 22);

		displayField.setFont(font1);
		windowContent.add("North", displayField);

		// Create buttons using constructor of the
		// class JButton that takes the label of the
		// button as a parameter

		// Create the frame and set its content pane
		JFrame frame = new JFrame("Calculator v1.0 by O.Khodakovskyi");

		frame.setLocationRelativeTo(null);

		button0 = new JButton("0");
		button0.setFont(font1);
		button0.addActionListener(calcEngine);

		button1 = new JButton("1");
		button1.setFont(font1);
		button1.addActionListener(calcEngine);

		button2 = new JButton("2");
		button2.setFont(font1);
		button2.addActionListener(calcEngine);

		button3 = new JButton("3");
		button3.setFont(font1);
		button3.addActionListener(calcEngine);

		button4 = new JButton("4");
		button4.setFont(font1);
		button4.addActionListener(calcEngine);

		button5 = new JButton("5");
		button5.setFont(font1);
		button5.addActionListener(calcEngine);

		button6 = new JButton("6");
		button6.setFont(font1);
		button6.addActionListener(calcEngine);

		button7 = new JButton("7");
		button7.setFont(font1);
		button7.addActionListener(calcEngine);

		button8 = new JButton("8");
		button8.setFont(font1);
		button8.addActionListener(calcEngine);

		button9 = new JButton("9");
		button9.setFont(font1);
		button9.addActionListener(calcEngine);

		buttonExit = new JButton("Exit");
		buttonExit.setFont(font1);
		buttonExit.addActionListener(calcEngine);

		buttonPoint = new JButton(".");
		buttonPoint.setFont(font1);
		buttonPoint.addActionListener(calcEngine);

		buttonC = new JButton(numericPad[2]);
		buttonC.setFont(font1);
		buttonC.addActionListener(calcEngine);

		buttonCE = new JButton(numericPad[1]);
		buttonCE.setFont(font1);
		buttonCE.addActionListener(calcEngine);

		buttonEquals = new JButton(operPad[3][1]);
		buttonEquals.setFont(font1);
		buttonEquals.addActionListener(calcEngine);

		buttonMinus = new JButton(operPad[3][0]);
		buttonMinus.setFont(font1);
		buttonMinus.addActionListener(calcEngine);

		buttonPlus = new JButton(operPad[4][0]);
		buttonPlus.setFont(font1);
		buttonPlus.addActionListener(calcEngine);

		buttonMultiply = new JButton(operPad[2][0]); // multiplic.
		buttonMultiply.setFont(font1);
		buttonMultiply.addActionListener(calcEngine);

		buttonDivide = new JButton(operPad[1][0]); // division
		buttonDivide.setFont(font1);
		buttonDivide.addActionListener(calcEngine);

		buttonBackSpace = new JButton(numericPad[0]);
		buttonBackSpace.setFont(font1);
		buttonBackSpace.addActionListener(calcEngine);

		buttonMemSave = new JButton(memPad[0]);
		buttonMemSave.setFont(font1);
		buttonMemSave.addActionListener(calcEngine);

		buttonMemRead = new JButton(memPad[1]);
		buttonMemRead.setFont(font1);
		buttonMemRead.addActionListener(calcEngine);

		buttonMemClear = new JButton(memPad[2]);
		buttonMemClear.setFont(font1);
		buttonMemClear.addActionListener(calcEngine);

		buttonMemPlus = new JButton(memPad[3]);
		buttonMemPlus.setFont(font1);
		buttonMemPlus.addActionListener(calcEngine);

		buttonMemMinus = new JButton(memPad[4]);
		buttonMemMinus.setFont(font1);
		buttonMemMinus.addActionListener(calcEngine);

		// ------------------aux buttons
		button1x = new JButton(operPad[1][1]);
		button1x.setFont(font1);
		button1x.addActionListener(calcEngine);

		buttonX2 = new JButton(sciPad[1][3]);
		buttonX2.setFont(font1);
		buttonX2.addActionListener(calcEngine);

		buttonX3 = new JButton(sciPad[3][3]);
		buttonX3.setFont(font1);
		buttonX3.addActionListener(calcEngine);

		buttonPowXY = new JButton(sciPad[2][3]);
		buttonPowXY.setFont(font1);
		buttonPowXY.addActionListener(calcEngine);

		buttonLog = new JButton(sciPad[4][3]);
		buttonLog.setFont(font1);
		buttonLog.addActionListener(calcEngine);

		buttonLn = new JButton(sciPad[0][2]);
		buttonLn.setFont(font1);
		buttonLn.addActionListener(calcEngine);

		buttonSqrt = new JButton(operPad[0][1]);
		buttonSqrt.setFont(font1);
		buttonSqrt.addActionListener(calcEngine);

		buttonSin = new JButton(sciPad[1][2]);
		buttonSin.setFont(font1);
		buttonSin.addActionListener(calcEngine);

		buttonCos = new JButton(sciPad[2][2]);
		buttonCos.setFont(font1);
		buttonCos.addActionListener(calcEngine);

		buttonTan = new JButton(sciPad[3][2]);
		buttonTan.setFont(font1);
		buttonTan.addActionListener(calcEngine);

		buttonPI = new JButton(sciPad[3][0]);
		buttonPI.setFont(font1);
		buttonPI.addActionListener(calcEngine);

		// Create the panel with the GridLayout with 12 buttons �
		// 10 numeric ones, period, and the equal sign
		numPan = new JPanel();
		numPan.setLayout(new GridLayout(4, 3));

		p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

		operPanel = new JPanel();
		operPanel.setLayout(new BoxLayout(operPanel, BoxLayout.PAGE_AXIS));

		MemPanel = new JPanel();
		MemPanel.setLayout(new BoxLayout(MemPanel, BoxLayout.PAGE_AXIS));

		auxControl = new JPanel();
		auxControl.setLayout(new BoxLayout(auxControl, BoxLayout.X_AXIS));

		contrPan = new JPanel();
		contrPan.setLayout(new GridLayout(4, 1));

		auxRightPanel = new JPanel();
		auxRightPanel.setLayout(new GridLayout(4, 3));

		// Add window controls to the panel numPan

		numPan.add(button1);
		numPan.add(button2);
		numPan.add(button3);
		numPan.add(button4);
		numPan.add(button5);
		numPan.add(button6);
		numPan.add(button7);
		numPan.add(button8);
		numPan.add(button9);
		numPan.add(button0);
		numPan.add(buttonPoint);
		numPan.add(buttonEquals);

		auxRightPanel.add(button1x);
		auxRightPanel.add(buttonX2);
		auxRightPanel.add(buttonX3);
		auxRightPanel.add(buttonPowXY);
		auxRightPanel.add(buttonLog);
		auxRightPanel.add(buttonLn);
		auxRightPanel.add(buttonSqrt);
		auxRightPanel.add(buttonSin);
		auxRightPanel.add(buttonCos);
		auxRightPanel.add(buttonTan);
		auxRightPanel.add(buttonPI);

		// ====control panel ================
		buttonExit.setMaximumSize(new Dimension(Integer.MAX_VALUE, buttonExit
				.getMinimumSize().height));
		contrPan.add(buttonExit);

		// ====operational panel===================
		buttonC.setMaximumSize(new Dimension(Integer.MAX_VALUE, buttonC
				.getMinimumSize().height));
		operPanel.add(buttonC);

		buttonCE.setMaximumSize(new Dimension(Integer.MAX_VALUE, buttonCE
				.getMinimumSize().height));
		operPanel.add(buttonCE);

		buttonPlus.setMaximumSize(new Dimension(Integer.MAX_VALUE, buttonPlus
				.getMinimumSize().height));
		operPanel.add(buttonPlus);

		buttonMinus.setMaximumSize(new Dimension(Integer.MAX_VALUE, buttonMinus
				.getMinimumSize().height));
		operPanel.add(buttonMinus);

		buttonMultiply.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				buttonMultiply.getMinimumSize().height));
		operPanel.add(buttonMultiply);

		buttonDivide.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				buttonDivide.getMinimumSize().height));
		operPanel.add(buttonDivide);

		// --------------------------Memory Panel---------------------
		buttonBackSpace.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				buttonBackSpace.getMinimumSize().height));
		MemPanel.add(buttonBackSpace);

		buttonMemSave.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				buttonMemSave.getMinimumSize().height));
		MemPanel.add(buttonMemSave);

		buttonMemRead.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				buttonMemRead.getMinimumSize().height));
		MemPanel.add(buttonMemRead);

		buttonMemClear.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				buttonMemClear.getMinimumSize().height));
		MemPanel.add(buttonMemClear);

		buttonMemPlus.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				buttonMemPlus.getMinimumSize().height));
		MemPanel.add(buttonMemPlus);

		buttonMemMinus.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				buttonMemMinus.getMinimumSize().height));
		MemPanel.add(buttonMemMinus);

		p2.add(Box.createRigidArea(new Dimension(20, 0)));
		p2.add(operPanel);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		p2.add(MemPanel);
		p2.add(Box.createRigidArea(new Dimension(20, 0)));

		auxControl.add(Box.createRigidArea(new Dimension(20, 0)));
		auxControl.add(auxRightPanel);
		auxControl.add(Box.createRigidArea(new Dimension(10, 0)));
		auxControl.add(contrPan);

		// Add the panel numPan to the center of the window
		windowContent.add("Center", numPan);
		windowContent.add("West", p2);
		windowContent.add("East", auxControl);
		// windowContent.add("East", operPanel);

		frame.setContentPane(windowContent);
		// Set the size of the window big enough to accomodate all controls
		frame.setSize(new Dimension(800, 400));
		// frame.pack();
		// Display the window
		frame.setVisible(true);

	}

	public void setCalcInCalcUI(Calc calc) {
		this.calc = calc;
	}

	public JButton getButtonBackSpace() {
		return buttonBackSpace;
	}

	public void setButtonBackSpace(JButton buttonBackSpace) {
		this.buttonBackSpace = buttonBackSpace;
	}

	public JButton getButton0() {
		return button0;
	}

	public void setButton0(JButton button0) {
		this.button0 = button0;
	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public void setButton3(JButton button3) {
		this.button3 = button3;
	}

	public JButton getButton4() {
		return button4;
	}

	public void setButton4(JButton button4) {
		this.button4 = button4;
	}

	public JButton getButton5() {
		return button5;
	}

	public void setButton5(JButton button5) {
		this.button5 = button5;
	}

	public JButton getButton6() {
		return button6;
	}

	public void setButton6(JButton button6) {
		this.button6 = button6;
	}

	public JButton getButton7() {
		return button7;
	}

	public void setButton7(JButton button7) {
		this.button7 = button7;
	}

	public JButton getButton8() {
		return button8;
	}

	public void setButton8(JButton button8) {
		this.button8 = button8;
	}

	public JButton getButton9() {
		return button9;
	}

	public void setButton9(JButton button9) {
		this.button9 = button9;
	}

	public JButton getButtonPoint() {
		return buttonPoint;
	}

	public void setButtonPoint(JButton buttonPoint) {
		this.buttonPoint = buttonPoint;
	}

	public JButton getButtonPlus() {
		return buttonPlus;
	}

	public void setButtonPlus(JButton buttonPlus) {
		this.buttonPlus = buttonPlus;
	}

	public JButton getButtonMinus() {
		return buttonMinus;
	}

	public void setButtonMinus(JButton buttonMinus) {
		this.buttonMinus = buttonMinus;
	}

	public JButton getButtonMultiply() {
		return buttonMultiply;
	}

	public void setButtonMultiply(JButton buttonMultiply) {
		this.buttonMultiply = buttonMultiply;
	}

	public JButton getButtonDivide() {
		return buttonDivide;
	}

	public void setButtonDivide(JButton buttonDivide) {
		this.buttonDivide = buttonDivide;
	}

	public JTextField getDisplayField() {
		return displayField;
	}

	public void setDisplayField(JTextField displayField) {
		this.displayField = displayField;
	}

	@Override
	public void setDisplayFieldText(String text) {

		this.displayField.setText(text);
	}

	public Calc getCalc() {
		return calc;
	}

	public void setCalc(Calc calc) {
		this.calc = calc;
	}

	public JButton getButtonEquals() {
		return buttonEquals;
	}

	public void setButtonEquals(JButton buttonEquals) {
		this.buttonEquals = buttonEquals;
	}

	public JButton getButtonC() {
		return buttonC;
	}

	public void setButtonC(JButton buttonC) {
		this.buttonC = buttonC;
	}

	public JButton getButtonCE() {
		return buttonCE;
	}

	public void setButtonCE(JButton buttonCE) {
		this.buttonCE = buttonCE;
	}

	public JButton getButtonMemSave() {
		return buttonMemSave;
	}

	public void setButtonMemSave(JButton buttonMemSave) {
		this.buttonMemSave = buttonMemSave;
	}

	public JButton getButtonMemRead() {
		return buttonMemRead;
	}

	public void setButtonMemRead(JButton buttonMemRead) {
		this.buttonMemRead = buttonMemRead;
	}

	public JButton getButtonMemClear() {
		return buttonMemClear;
	}

	public void setButtonMemClear(JButton buttonMemClear) {
		this.buttonMemClear = buttonMemClear;
	}

	public JButton getButtonMemPlus() {
		return buttonMemPlus;
	}

	public void setButtonMemPlus(JButton buttonMemPlus) {
		this.buttonMemPlus = buttonMemPlus;
	}

	public JButton getButtonMemMinus() {
		return buttonMemMinus;
	}

	public void setButtonMemMinus(JButton buttonMemMinus) {
		this.buttonMemMinus = buttonMemMinus;
	}

	public JButton getButtonExit() {
		return buttonExit;
	}

	public void setButtonExit(JButton buttonExit) {
		this.buttonExit = buttonExit;
	}

}
