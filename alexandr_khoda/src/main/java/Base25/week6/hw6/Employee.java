package Base25.week6.hw6;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Employee extends AbstractEmployee {

	public Employee(String[][] sirNames, String[][] names,
			String[][] patronymicName, String[] departments, Firma firma) {
		super(sirNames, names, patronymicName, departments, firma);
		// TODO Auto-generated constructor stub
	}

	public Employee(String sirName, String name, String patronymicName,
			int sex, Firma firma, GregorianCalendar dateOfBirth, double salary,
			double seniority, String deptName) {
		super(sirName, name, patronymicName, sex, firma, dateOfBirth, salary,
				seniority, deptName);
	}

	@Override
	public int binarySearchByIDSubOrdinates(int id) {
		return -1;
	}

	@Override
	public void sellAmount(int salesMoney) {
	}

	@Override
	public String getEmployeeType() {
		return "emp";
	}

	@Override
	public int getSalesMonthly() {
		return 0;
	}

	@Override
	public ArrayList<Integer> getSubordId() {
		return new ArrayList<Integer>();
	}

	@Override
	public String getStrSubordinates(Firma firma) {
		return "";
	}

	@Override
	public void setSalesMonthly(int SalesMonthly) {

	}
}
