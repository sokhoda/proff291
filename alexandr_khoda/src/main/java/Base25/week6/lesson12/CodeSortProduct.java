package Base25.week6.lesson12;

import java.util.Comparator;

public class CodeSortProduct implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return new Integer(o1.getCode()).compareTo(new Integer(o2.getCode()));
	}
}
