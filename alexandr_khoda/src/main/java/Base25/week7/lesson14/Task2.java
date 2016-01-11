package Base25.week7.lesson14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Task2 {

	public static void main(String[] args) throws IOException {
		Reader isr = new InputStreamReader(System.in);

		BufferedReader br = new BufferedReader(isr);

		System.out.println("������� �����:");
		String s = br.readLine();

		try {
			// Scanner sc = new Scanner();
			Integer.parseInt(s);
			System.out.println("����� �����");
		}
		catch (NumberFormatException e) {
			try {
				Double.parseDouble(s);
				System.out.println("������� �����");
			}
			catch (NumberFormatException e1) {
				System.out.println("�� �����");
			}
		}
		// System.out.println((char) br.read());
	}
}
