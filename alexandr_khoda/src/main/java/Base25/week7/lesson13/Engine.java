package Base25.week7.lesson13;

import java.io.Serializable;

public class Engine implements Cloneable, Serializable {
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private int					EngNo;

	public Engine(int engNo) {
		EngNo = engNo;
	}

	@Override
	public Engine clone() throws CloneNotSupportedException {
		Engine engine1 = (Engine) super.clone();
		return engine1;
	}

	public int getEngNo() {
		return EngNo;
	}

	public void setEngNo(int engNo) {
		EngNo = engNo;
	}

}
