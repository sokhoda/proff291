package Base25.week6.hw6;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Seller extends AbstractEmployee {
	private int	raiseForSalesPercent	= 30;
	private int	salesMonthly;

	public Seller(String[][] sirNames, String[][] names,
			String[][] patronymicName, String[] departments, Firma firma) {
		super(sirNames, names, patronymicName, departments, firma);

		// ArrayList<Employee> employee = firma.getEmployee();
		// ��������� �������
		this.salesMonthly = 0;

		this.setSalaryToHandIn(this.getSalary() + this.salesMonthly
				* raiseForSalesPercent * 0.01);

		// this.subordinates = subordinates;
		// this.raise = raise
	}

	public Seller(String sirName, String name, String patronymicName, int sex,
			Firma firma, GregorianCalendar dateOfBirth, double salary,
			double seniority, String deptName, int salesMonthly) {

		super(sirName, name, patronymicName, sex, firma, dateOfBirth, salary,
				seniority, deptName);
		this.salesMonthly = salesMonthly;

		this.setSalaryToHandIn(this.getSalary() + this.salesMonthly
				* raiseForSalesPercent * 0.01);
	}

	@Override
	public void sellAmount(int salesMoney) {
		setSalesMonthly(getSalesMonthly() + salesMoney);
		setSalaryToHandIn(getSalary() + 0.01 * raiseForSalesPercent
				* getSalesMonthly());
	}

	@Override
	public String getEmployeeType() {
		return "sel";
	}

	@Override
	public int binarySearchByIDSubOrdinates(int id) {
		return -1;
	}

	@Override
	public int getSalesMonthly() {
		return salesMonthly;
	}

	@Override
	public void setSalesMonthly(int salesMonthly) {
		this.salesMonthly = salesMonthly;
	}

	@Override
	public ArrayList<Integer> getSubordId() {
		return new ArrayList<Integer>();
	}

	@Override
	public String getStrSubordinates(Firma firma) {
		return "";
	}

}
