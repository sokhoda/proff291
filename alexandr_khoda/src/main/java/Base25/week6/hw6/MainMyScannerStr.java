package Base25.week6.hw6;

import java.util.Scanner;

public class MainMyScannerStr {
	public static void main(String[] args) {
		// MyScannerStr scan = new MyScannerStr("4 5 6");
		// MyScannerStr scan = new MyScannerStr("f/3/5/fe/f3");
		// "MY NAME IS OLEKSANDR. AND WHAT IS YOUR NAME ?");
		// scan.close();
		// scan.useDelimiter('.');
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("/");
		String ss1 = scan.next();
		String ss2 = scan.next();
		System.out.println(ss1 + ", " + ss2);

		// System.out.println(scan.nextLine());
		// System.out.println(scan.nextLine());

		// String ss3 = scan.next();
		// System.out.println(ss1 + ", " + ss2 + ", " + ss3);

		// int i1 = scan.nextInt();
		// int i2 = scan.nextInt();
		// int i3 = scan.nextInt();
		// System.out.println(i1 + ", " + i2 + ", " + i3);
		// scan.useDelimiter('/');
		// while (scan.hasNext()) {
		// System.out.println(scan.next());
		// }
		// int i1 = scan.nextInt();
		// int i2 = scan.nextInt();
		// int i3 = scan.nextInt();
		// System.out.println(i1 + ", " + i2 + ", " + i3);

		// while (scan.hasNextInt()) {
		// System.out.println(scan.nextInt());
		// }

		// System.out.println(scan.nextInt());
		// System.out.println(scan.nextLine());
	}
}
