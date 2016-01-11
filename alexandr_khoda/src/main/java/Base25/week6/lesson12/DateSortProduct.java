package Base25.week6.lesson12;

import java.util.Comparator;

public class DateSortProduct implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

}
