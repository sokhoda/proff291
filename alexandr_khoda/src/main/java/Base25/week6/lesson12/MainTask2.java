package Base25.week6.lesson12;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTask2 {
	public static int	ThreadNum	= 10;

	public static void main(String[] args) {
		ArrayList<Task2Thread> arr = new ArrayList<Task2Thread>(ThreadNum);

		for (int i = 0; i < ThreadNum; i++) {
			arr.add((new Task2Thread("поток_" + i)));
			arr.get(i).start();
		}

		Scanner scan = new Scanner(System.in);
		Character val = null;
		int k = 0;
		while (k < ThreadNum) {
			val = scan.next().charAt(0);
			if (val != null) {
				arr.get(k++).interrupt();
				val = null;
			}
		}
	}
}
