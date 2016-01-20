package Base25.week6.lesson11;

public class Animal<T> {
	private T	zver;

	public Animal(T zver) {
		this.zver = zver;

	}

	public void say() {
		if (zver instanceof Dog) Dog.say();
		if (zver instanceof Cat) Cat.say();
		if (zver instanceof Leo) Leo.say();
	}

	public void move() {
		if (zver instanceof Dog) Dog.move();
		// if (zver instanceof Cat) Cat.move();
		// if (zver instanceof Leo) Leo.move();
	}
}
