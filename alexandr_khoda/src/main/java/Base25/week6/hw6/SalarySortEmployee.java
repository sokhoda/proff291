package Base25.week6.hw6;

import java.util.Comparator;

public class SalarySortEmployee implements Comparator<AbstractEmployee> {

	@Override
	public int compare(AbstractEmployee o1, AbstractEmployee o2) {
		return (int) (o1.getSalary() - o2.getSalary());
	}

}
