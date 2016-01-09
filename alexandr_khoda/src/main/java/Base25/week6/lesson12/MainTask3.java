package Base25.week6.lesson12;

public class MainTask3 {
	public static void main(String[] args) {
		Task3Thread thr = new Task3Thread("родительский поток");

		thr.start();
	}

}
