package Base25.week6.hw6;

import java.io.InputStreamReader;
import java.io.Reader;

public class MainMyScanner {
	public static void main(String[] args) {
		Reader reader = new InputStreamReader(System.in);
		MyScanner scan = new MyScanner(reader);
		// scan.close();
		// scan.useDelimiter('.');
		// scan.useDelimiter('/');
		// String ss1 = scan.next();
		// String ss2 = scan.next();
		// String ss3 = scan.next();
		// System.out.println(ss1 + ", " + ss2 + ", " + ss3);
		// while (scan.hasNext()) {
		// System.out.println(scan.next());
		// }
		int i1 = scan.nextInt();
		int i2 = scan.nextInt();
		int i3 = scan.nextInt();
		System.out.println(i1 + ", " + i2 + ", " + i3);
		// while (scan.hasNextInt()) {
		// System.out.println(scan.nextInt());
		// }

		// System.out.println(scan.nextInt());
		// System.out.println(scan.nextLine());
	}
}
