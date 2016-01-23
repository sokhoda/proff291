package Base25.week6.hw6;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar(2002, 0, 11);
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(format1.format(date.getTime()));
		Scanner scan = new Scanner(System.in);
		String[] dateArr = { "0" };
		System.out.println("������� ���� �������� (dd.mm.yyyy): ");
		String dateStr = scan.nextLine();
		dateArr = dateStr.split("\\.");
		GregorianCalendar dateOfBirth;
		try {
			int dd = Integer.parseInt(dateArr[0]);
			int mm = Integer.parseInt(dateArr[1]) - 1;
			int yyyy = Integer.parseInt(dateArr[2]);

			dateOfBirth = new GregorianCalendar(yyyy, mm, dd);

		}
		catch (NumberFormatException ex) {
			System.out.println("\n" + ex.getMessage());
		}
	}
}
