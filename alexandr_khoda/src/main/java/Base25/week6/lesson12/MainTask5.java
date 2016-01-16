package Base25.week6.lesson12;

import java.util.ArrayList;
import java.util.Vector;

public class MainTask5 {
	static int	ThreadNum	= 10;
	static int	MaxVal		= 10000;

	public static void main(String[] args) {

		int k = 1;

		if (k == 0) {
			ArrayList<Integer> val = new ArrayList<Integer>(MaxVal);
			for (int i = 0; i < MaxVal; i++) {
				val.add(i);
			}
			System.out.println(val);

			long t1 = System.nanoTime();
			Task5Thread[] thr = new Task5Thread[ThreadNum];

			for (int i = 0; i < thr.length; i++) {
				thr[i] = new Task5Thread(val, i * (MaxVal / ThreadNum),
						(MaxVal / ThreadNum));
				thr[i].start();
			}
			try {
				for (Task5Thread element : thr) {
					element.join();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			int sum = 0;
			for (Task5Thread element : thr) {
				sum += element.getSum();
			}
			long t2 = System.nanoTime();
			System.out.printf("ArrayList Time = %.2e", (t2 - t1) * 1.);
			System.out.println("\nсумма = " + sum);
		}

		if (k == 1) {
			Vector<Integer> vector = new Vector<Integer>(MaxVal);
			for (int i = 0; i < MaxVal; i++) {
				vector.add(i);
			}
			System.out.println(vector);

			long t1 = System.nanoTime();

			Task5ThreadVect[] thr = new Task5ThreadVect[ThreadNum];

			for (int i = 0; i < thr.length; i++) {
				thr[i] = new Task5ThreadVect(vector, i * (MaxVal / ThreadNum),
						(MaxVal / ThreadNum));
				thr[i].start();
			}
			try {
				for (Task5ThreadVect element : thr) {
					element.join();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			int sum = 0;
			for (Task5ThreadVect element : thr) {
				sum += element.getSum();
			}
			long t2 = System.nanoTime();
			System.out.printf("Vector Time = %.2e", (t2 - t1) * 1.);
			System.out.println("\nсумма = " + sum);
		}
	}
}
