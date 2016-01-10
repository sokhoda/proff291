package Base25.week6.lesson12;

public class MyClass extends Thread {
	String	name;

	public MyClass(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(name + " " + i);
		}
	}
}
