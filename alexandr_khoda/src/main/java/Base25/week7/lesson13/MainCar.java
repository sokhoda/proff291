package Base25.week7.lesson13;

public class MainCar {
	public static void main(String[] args) {
		Car car1 = new Car("AA 1111", new Engine(123456));
		Car car2 = null;
		try {
			car2 = car1.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(car1.getEngine() == car2.getEngine());
		car1.getEngine().setEngNo(5555555);
		System.out.println(car1.toString());
		System.out.println(car2.toString());
	}
}
