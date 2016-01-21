package Base25.week6.lesson11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MainProduct {

	public static void main(String[] args) {
		final int listSize = 2;
		Scanner scan = new Scanner(System.in);

		String[] products = { "������� ����������", "��� �����������",
				"����� ���������", "����� ������������", "���� �����������",
				"���� I ����", "���� ��������", "������� 20%", "����� 2.5%",
				"������ ��������" };
		ArrayList<Product> list = new ArrayList<Product>();
		for (int i = 0; i < listSize; i++) {
			int productInx = (int) (Math.random() * products.length);
			// int price = (int) (Math.random() * 900) + 100;
			int month = (int) (Math.random() * 11) + 1;
			int dayOfMonth = (int) (Math.random() * 29) + 1;
			// int yearOfPurchase = (int) (Math.random() * 10) + 2010;

			System.out.println("������� ����");
			int price = scan.nextInt();

			System.out.println("������� ��� �������:");
			int yearOfPurchase = scan.nextInt();

			GregorianCalendar date = new GregorianCalendar(yearOfPurchase,
					month, dayOfMonth);
			list.add(new Product(products[productInx], new Integer(price), date));

			// System.out.println("exception in main");
		}
		Collections.sort(list);
		System.out.println(list);

		Collections.sort(list, new DateOfPurchaseSortProduct());
		System.out.println("\n\nData sort");
		System.out.println(list);

		Collections.sort(list, new PriceSortProduct());
		System.out.println("\n\nPriceSort");
		System.out.println(list);

	}
}
