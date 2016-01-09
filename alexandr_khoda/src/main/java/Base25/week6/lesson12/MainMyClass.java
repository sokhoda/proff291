package Base25.week6.lesson12;

public class MainMyClass {
	public static void main(String[] args) {
		MyClass obj1 = new MyClass("поток1");
		MyClass obj2 = new MyClass("поток2");
		MyClass obj3 = new MyClass("поток3");
		obj1.start();
		obj2.start();
		obj3.start();
		System.out.println("end");

	}
}
