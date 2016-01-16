package Base25.week6.lesson12;

import java.util.Scanner;

public class MainTask1 {
	public static void main(String[] args) {
		Task1Thread thr1 = new Task1Thread();

		Scanner scan = new Scanner(System.in);
		Character val = null;

		thr1.start();
		while (val == null) {
			val = scan.next().charAt(0);
			if (val != null) thr1.interrupt();
		}
	}
}
