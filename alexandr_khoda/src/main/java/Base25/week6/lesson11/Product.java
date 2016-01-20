package Base25.week6.lesson11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Product implements Comparable<Product> {
	private String				name;
	private Integer				price;
	private GregorianCalendar	datePurchase;

	@Override
	public int compareTo(Product product) {
		return this.name.compareTo(product.name);
	}

	public Product(String name, Integer price, GregorianCalendar datePurchase) {
		this.name = name;
		try {
			setPrice(price);
			System.out.println("cont");
			setDatePurchase(datePurchase);
		}
		catch (NotValidYearOfPurchase e) {
			e.printStackTrace();
		}
		// catch (NotValidPriceException e) {
		// e.printStackTrace();
		// // System.out.println(e.getMessage());
		// }
	}

	@Override
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");

		return "\n" + getName() + "\t\t\t\t" + getPrice() + "\t\t\t\t"
				+ format1.format(getDatePurchase().getTime());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		try {
			if (price.intValue() < 0) {
				throw new NotValidPriceException(
						"���� �� ����� ���� �������������.");
			}
			else this.price = price;
		}
		catch (NotValidPriceException e) {
			e.printStackTrace();
			System.out.println("setPrice");
			System.exit(0);
		}

	}

	public GregorianCalendar getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(GregorianCalendar datePurchase)
			throws NotValidYearOfPurchase {
		// try {
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		if (datePurchase.get(GregorianCalendar.YEAR) < curYear) throw new NotValidYearOfPurchase(
				"��� ������� �� ����� ���� ������ �������� ����");
		else this.datePurchase = datePurchase;
		// }
		// catch (NotValidYearOfPurchase e) {
		// e.printStackTrace();
		// }
	}
}
