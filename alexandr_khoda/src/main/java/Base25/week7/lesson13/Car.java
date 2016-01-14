package Base25.week7.lesson13;

import java.io.Serializable;

public class Car implements Cloneable, Serializable {
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private String				carNo;
	private Engine				engine;

	public Car() {

	}

	public Car(String carNo, Engine engine) {
		this.carNo = carNo;
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "CarNo = " + getCarNo() + ", EngNo = " + getEngine().getEngNo();
	}

	@Override
	public Car clone() throws CloneNotSupportedException {
		Car car1 = (Car) super.clone();
		car1.setEngine(this.getEngine().clone());

		return car1;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
