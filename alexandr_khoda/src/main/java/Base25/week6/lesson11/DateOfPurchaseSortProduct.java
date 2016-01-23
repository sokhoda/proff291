package Base25.week6.lesson11;

import java.util.Comparator;

public class DateOfPurchaseSortProduct implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getDatePurchase().compareTo(o2.getDatePurchase());
	}

}
