package Base25.week6.lesson12;

import java.util.GregorianCalendar;

public class MainTask6 {
	static int	ThreadNum	= 10;
	static int	MaxVal		= 100000;

	// public static String getProductCode(int count) {
	// String s = "";
	// for (int i = 0; i < count; i++) {
	// s += Character.toString((char) ((int) (Math.random() * 24) + 1039));
	// }
	// return s;
	// }
	//
	// public static int getProductCode() {
	//
	// return (int) (Math.random() * 10000);
	// }

	public static void main(String[] args) throws InterruptedException {
		Shop shop = new Shop();
		String[] products = { "Колбаса Докторская", "Сыр Пырятынский",
				"Масло сливочное", "Масло подсолнечное", "Хлеб Белорусский",
				"Мука I сорт", "Яйцо куринное", "Сметана 20%", "Кефир 2.5%",
				"Живчик эхинацея", "Торт Київський", "Торт трюфель", "Курага",
				"Абрикос", "Слива", "Груша", "Яблуко", "Арахіс",
				"Крупа пшенична", "Крупа манна", "Помідор", "Огірок", "Банан",
				"Печиво \"Горішки\"", "Торт Грецький" };

		for (int i = 0; i < MaxVal; i++) {
			int productInx = (int) (Math.random() * products.length);
			int productSuff = (int) (Math.random() * 1000);
			int productQua = (int) (Math.random() * 10000);

			int price = (int) (Math.random() * 900) + 100;
			int year = (int) (Math.random() * 10) + 2005;
			int month = (int) (Math.random() * 11) + 1;
			int dayOfMonth = (int) (Math.random() * 29) + 1;

			GregorianCalendar date = new GregorianCalendar(year, month,
					dayOfMonth);
			shop.add(new Product(products[productInx] + " " + productSuff, i,
					price, productQua, date));
		}
		// System.out.println(shop.getList());
		// shop.printList();

		int k = 0;
		if (k == 0) {
			long t1 = 0;
			long t2 = 0;
			Task6Thread[] thr = new Task6Thread[ThreadNum];
			for (int i = 0; i < ThreadNum; i++) {
				thr[i] = new Task6Thread(shop.getList(), i
						* (MaxVal / ThreadNum), (MaxVal / ThreadNum));

			}
			for (int i = 0; i < ThreadNum; i++) {

				if (t1 == 0) t1 = System.nanoTime();
				thr[i].start();
			}
			// long t1 = System.nanoTime();

			long sum = 0;

			// boolean st;

			// st = st && (element.getState() == State.TERMINATED);
			// }
			// while (!st) {
			// st = true;
			// for (Task6Thread element : thr) {
			// st = st && (element.getState() == State.TERMINATED);
			// }
			//
			// }
			for (Task6Thread element : thr) {
				element.join();
				// System.out.println(element.getName() + " State = "
				// + element.getState());
				sum += element.getSum();
			}

			t2 = System.nanoTime();
			System.out.printf("\n10 Threads Sum time = %.2e", (t2 - t1) * 1.);
			System.out.printf("\nсумма = %5.10e ListSize = %d", sum * 1., shop
					.getList().size());
		}

		if (k == 1) {
			long t1 = System.nanoTime();
			long sum = 0;
			for (int i = 0; i < shop.getList().size(); i++) {
				sum += shop.getList().get(i).getKol()
						* shop.getList().get(i).getPrice();
			}
			long t2 = System.nanoTime();
			System.out.printf("\n1 Thread Sum time = %.2e", (t2 - t1) * 1.);
			System.out.printf("\nсумма = %5.10e ListSize = %d", sum * 1., shop
					.getList().size());
		}
		// System.out.println("\n\n");
		// shop.sortByDate();
		// shop.printList();

		// int rand = (int) (Math.random() * Shop.CodeNum);
		// int inx = shop.binarySearchByCode(rand,true);
		//
		// // while (inx == -1) {
		// // rand = (int) (Math.random() * Shop.CodeNum);
		// // inx = shop.binarySearchByCode(rand,true);
		// // }
		// if (inx > -1) System.out.println("\ninx = " + inx + ", code = " +
		// rand
		// + "\n" + shop.getList().get(inx));
		// // /--------------------
		// rand = (int) (Math.random() * 30) + 1;
		// int rand2 = (int) (Math.random() * 12) + 1;
		// inx = shop.binarySearchByDate(rand + "." + rand2 + ".2006");
		//
		// // while (inx == -1) {
		// // rand = (int) (Math.random() * 30) + 1;
		// // rand2 = (int) (Math.random() * 12) + 1;
		// // inx = shop.binarySearchByDate(rand + "." + rand2 + ".2006");
		// // }
		// if (inx > -1) System.out.println("\ninx = " + inx + ", Date = " +
		// rand
		// + "." + rand2 + ".2006" + "\n" + shop.getList().get(inx));

	}
}