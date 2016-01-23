package Base25.week6.hw6;

import java.util.Comparator;

public class DeptSortEmployee implements Comparator<AbstractEmployee> {
	@Override
	public int compare(AbstractEmployee o1, AbstractEmployee o2) {
		return o1.getDeptName().compareTo(o2.getDeptName());
	}

}
