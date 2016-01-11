package Base25.week6.lesson12;

import java.util.ArrayList;
import java.util.Vector;

public class Task4 {
	static int	ThreadNum	= 10;
	static int	MaxVal		= 10000;

	public static void main(String[] args) throws InterruptedException {

		int k = 0;

		if (k == 0) {

			// ArrayList<Thread4> arr = new ArrayList<Thread4>(ThreadNum);
			Thread4[] arr = new Thread4[ThreadNum];
			ArrayList<Integer> val = new ArrayList<Integer>(MaxVal);

			long t1 = System.nanoTime();
			for (int i = 0; i < ThreadNum; i++) {
				arr[i] = ((new Thread4("поток_" + i, val, (MaxVal / ThreadNum))));
				arr[i].start();
			}
			for (int i = 0; i < ThreadNum; i++) {
				arr[i].join();
			}

			long t2 = System.nanoTime();

			System.out.println(val.size());
			System.out.println("\n");
			System.out.println(val);
			System.out.printf("\nArrayList Time = %.2e", (t2 - t1) * 1.);

			System.out.println("\n" + val.size());
		}

		if (k == 1) {
			Thread4Vect[] arr = new Thread4Vect[ThreadNum];
			Vector<Integer> vector = new Vector<Integer>(MaxVal);

			long t1 = System.nanoTime();
			for (int i = 0; i < ThreadNum; i++) {
				arr[i] = ((new Thread4Vect("поток_" + i, vector,
						(MaxVal / ThreadNum))));
				arr[i].start();
			}
			for (int i = 0; i < ThreadNum; i++) {
				arr[i].join();
			}
			// while (vector.size() < MaxVal) {
			// }
			long t2 = System.nanoTime();
			System.out.println(vector.size());
			System.out.println("\n" + vector);
			System.out.printf("Vector Time = %.2e", (t2 - t1) * 1.);
		}
	}
}

// boolean bl = true;
// for (Thread4 element : arr) {
// bl = bl && element.isDone();
// }
// while (!bl) {
// bl = true;
// for (Thread4 element : arr) {
// // if (element.isDone())
// // System.out.println(element.getTitle()
// // + " завершил работу " + element.getState());
// bl = bl && element.isDone();
// }
// // if (val.size() % 1000 == 0) System.out.println(val.size());
// }
// while (val.size() < MaxVal) {
// Thread.sleep(100);
// System.out.println(val.size());
// if (val.size() % 10 == 0) System.out.println(val.size());
// }
