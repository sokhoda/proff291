package Base25.week6.lesson11;

public class Task3 {
	public static void main(String[] args) {
		Animal<Dog> animal1 = new Animal<>(new Dog());
		Animal<Cat> animal2 = new Animal<>(new Cat());
		Animal<Leo> animal3 = new Animal<>(new Leo());
		animal1.say();
		// if (animal1 instanceof Animal)
		// System.out.println("animal1 = Animal");
		animal1.move();
		animal2.say();
		animal2.move();
		animal3.say();
	}
}
