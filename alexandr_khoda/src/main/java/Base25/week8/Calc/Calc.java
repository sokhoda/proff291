package Base25.week8.Calc;

public class Calc {
	private AbstractProcessor	proc;
	private CalcUI				calcUI;
	private CalcFX				calcFX;

	public Calc(AbstractProcessor pr, CalcUI calcUI) {
		proc = pr;
		this.calcUI = calcUI;
		calcUI.setCalcInCalcUI(this);
	}

	public CalcUI getCalcUI() {
		return calcUI;
	}

	public void setCalcUI(CalcUI calcUI) {
		this.calcUI = calcUI;
	}

	public AbstractProcessor getProc() {
		return proc;
	}

	public void setProc(AbstractProcessor proc) {
		this.proc = proc;
	}

	public CalcFX getCalcFX() {
		return calcFX;
	}

	public void setCalcFX(CalcFX calcFX) {
		this.calcFX = calcFX;
	}
}