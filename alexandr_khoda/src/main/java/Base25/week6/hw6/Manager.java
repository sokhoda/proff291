package Base25.week6.hw6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Manager extends AbstractEmployee {
	private int					raiseForEachSubOrdinate	= 50;
	private ArrayList<Integer>	subordId				= new ArrayList<Integer>();

	public Manager(String[][] sirNames, String[][] names,
			String[][] patronymicName, String[] departments, Firma firma,
			int maxSubOrdCount) {
		super(sirNames, names, patronymicName, departments, firma);

		ArrayList<AbstractEmployee> employee = firma.getEmployee();
		// ��������� �����������
		getSubOrdinates(employee, maxSubOrdCount);

		this.setSalaryToHandIn(this.getSalary() + subordId.size()
				* raiseForEachSubOrdinate);

		// this.subordinates = subordinates;
		// this.raise = raise
	}

	public Manager(String sirName, String name, String patronymicName, int sex,
			Firma firma, GregorianCalendar dateOfBirth, double salary,
			double seniority, String deptName, ArrayList<Integer> subordId) {
		super(sirName, name, patronymicName, sex, firma, dateOfBirth, salary,
				seniority, deptName);
		if (subordId != null) {
			for (Integer subord : subordId) {
				this.subordId.add(subord);
			}
		}
	}

	// ��������� �����������
	private void getSubOrdinates(ArrayList<AbstractEmployee> employee,
			int maxSubOrdCount) {

		if (maxSubOrdCount > employee.size()) {
			try {
				throw new MaxSubOrdCountException(
						"ʳ������ �������� � ��������� "
								+ this.getSirName()
								+ " �������� �������� ������� ���������� = "
								+ employee.size());
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}

		int currSubOrdCnt = (int) (Math.random() * maxSubOrdCount);
		int emplInx = (int) (Math.random() * employee.size());
		int currRndId = employee.get(emplInx).getId();

		for (int i = 0; i < currSubOrdCnt; i++) {
			while (binarySearchByIDSubOrdinates(currRndId) != -1
					|| this.getId() == currRndId) {
				emplInx = (int) (Math.random() * employee.size());
				currRndId = employee.get(emplInx).getId();
			}
			subordId.add(currRndId);
		}
	}

	@Override
	public int binarySearchByIDSubOrdinates(int id) {

		if (subordId == null) return -1;
		if (subordId.size() == 0) return -1;
		Collections.sort(subordId);

		int lBound = 0;
		int rBound = subordId.size() - 1;
		boolean cond = (subordId.get(lBound) == id)
				|| (subordId.get(rBound) == id);

		while ((!cond) && (rBound - lBound) > 1) {
			int center = (rBound + lBound) / 2;

			if (id < subordId.get(center)) rBound = center;
			else lBound = center;
			cond = (subordId.get(lBound) == id) || (subordId.get(rBound) == id);
		}
		if (cond) {
			if (subordId.get(lBound) == id) return lBound;
			else return rBound;
		}
		else {
			return -1;
		}
	}

	public void setSubordId(ArrayList<Integer> subordId) {
		this.subordId = subordId;
	}

	@Override
	public ArrayList<Integer> getSubordId() {
		return subordId;
	}

	@Override
	public String getEmployeeType() {
		return "mgr";
	}

	@Override
	public int getSalesMonthly() {
		return 0;
	}

	@Override
	public void sellAmount(int salesMoney) {
	}

	@Override
	public void setSalesMonthly(int SalesMonthly) {

	}

	@Override
	public String getStrSubordinates(Firma firma) {
		if (subordId.size() == 0) return "";
		String s1 = "\n";

		for (int i = 0; i < subordId.size(); i++) {
			AbstractEmployee ae = firma.binarySearchByIDAbstrEmployee(subordId
					.get(i));
			s1 += ae.getSirName() + " " + ae.getName() + " "
					+ ae.getPatronymicName()
					+ (i < subordId.size() - 1 ? ",\n" : "");
		}
		return s1;
	}

}
