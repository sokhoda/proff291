package Base25.week6.hw6;

import java.util.ArrayList;

public interface Employable {
	ArrayList<Integer> getSubordId();

	String getStrSubordinates(Firma firma);

	void setSalesMonthly(int SalesMonthly);

	void sellAmount(int salesMoney);

	int getSalesMonthly();

	String getEmployeeType();

	void countVacationDays(Firma firma);

	public int binarySearchByIDSubOrdinates(int id);
}
