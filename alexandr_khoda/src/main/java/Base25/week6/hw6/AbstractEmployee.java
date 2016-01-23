package Base25.week6.hw6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractEmployee implements Comparable<AbstractEmployee>,
		Employable {
	private static int			MaxID	= 10000;

	private int					id;
	private String				sirName;
	private String				name;
	private String				patronymicName;
	private int					sex;
	private GregorianCalendar	dateOfBirth;
	private double				salary;			// ������
	private double				salaryAcc;			// ������� ���������
	private double				seniority;			// ����
	private double				vacationDays;		// ������� �����. ���
	// ��������
	private GregorianCalendar	dateOfLastVacation;
	private String				deptName;
	private double				salaryToHandIn;	// �� ������ � ���������

	public AbstractEmployee(String[][] sirNames, String[][] names,
			String[][] patronymicName, String[] departments, Firma firma) {

		String[] params = getEmployee(sirNames, names, patronymicName);
		if (departments == null) return;
		if (params != null && departments.length > 0) {

			int id = (int) (Math.random() * MaxID);

			while (firma.binarySearchByID(id) != -1) {
				id = (int) (Math.random() * MaxID);
			}
			this.id = id;
			this.sirName = params[0];
			this.name = params[1];
			this.patronymicName = params[2];
			this.sex = Integer.parseInt(params[3]);

			this.dateOfBirth = getRandDate(40, 1957, 11, 1, 28, 1);
			this.salary = (int) (Math.random() * 4000) + 2000;
			this.salaryAcc = 0;// (int) (Math.random() * 1000000000) +
			// 1000000000;
			this.seniority = (Math.random() * 8);
			this.vacationDays = 0;// (int) (Math.random() * 21);
			this.dateOfLastVacation = getRandDate(4, 2012, 11, 1, 28, 1);
			this.deptName = departments[(int) (Math.random() * departments.length)];
			this.salaryToHandIn = this.salary;
		}
	}

	public AbstractEmployee(String sirName, String name, String patronymicName,
			int sex, Firma firma, GregorianCalendar dateOfBirth, double salary,
			double seniority, String deptName) {

		int id = (int) (Math.random() * MaxID);

		while (firma.binarySearchByID(id) != -1) {
			id = (int) (Math.random() * MaxID);
		}
		this.id = id;
		this.sirName = sirName;
		this.name = name;
		this.patronymicName = patronymicName;
		this.sex = sex;

		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.salaryAcc = 0;// (int) (Math.random() * 1000000000) +
		// 1000000000;
		this.seniority = seniority;
		this.vacationDays = 0;// (int) (Math.random() * 21);
		this.dateOfLastVacation = getCurDate();
		this.deptName = deptName;
		this.salaryToHandIn = 0;
	}

	public GregorianCalendar getRandDate(int kYear, int minYear, int kMonth,
			int minMonth, int kDay, int minDay) {
		int year = (int) (Math.random() * kYear) + minYear;
		int month = (int) (Math.random() * kMonth) + minMonth;
		int dayOfMonth = (int) (Math.random() * kDay) + minDay;

		return new GregorianCalendar(year, month, dayOfMonth);

	}

	public static GregorianCalendar getCurDate() {
		int curDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int curMonth = Calendar.getInstance().get(Calendar.MONTH);
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		return new GregorianCalendar(curYear, curMonth, curDay);
	}

	@Override
	public void countVacationDays(Firma firma) {
		ArrayList<AbstractEmployee> employee = firma.getEmployee();
		GregorianCalendar curDate = getCurDate();

		for (AbstractEmployee empl : employee) {
			double monthDiff = monthsBetween(curDate,
					empl.getDateOfLastVacation());
			if (monthDiff >= 6.) {
				empl.setVacationDays(monthDiff * 2);
			}
		}

	}

	public static double monthsBetween(Calendar date1, Calendar date2) {
		double monthsBetween = 0;
		// difference in month for years
		monthsBetween = (date1.get(Calendar.YEAR) - date2.get(Calendar.YEAR)) * 12;
		// difference in month for months
		monthsBetween += date1.get(Calendar.MONTH) - date2.get(Calendar.MONTH);
		// difference in month for days
		if (date1.get(Calendar.DAY_OF_MONTH) != date1
				.getActualMaximum(Calendar.DAY_OF_MONTH)
				&& date2.get(Calendar.DAY_OF_MONTH) != date2
						.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			monthsBetween += ((date1.get(Calendar.DAY_OF_MONTH) - date2
					.get(Calendar.DAY_OF_MONTH)) / 31d);
		}
		return monthsBetween;
	}

	@Override
	public int compareTo(AbstractEmployee o1) {
		return this.getId() - o1.getId();
	}

	@Override
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");

		return id + ", " + sirName + " " + name + " " + patronymicName + ", "
				+ (sex == 1 ? "���" : "���") + ", "
				+ format1.format(dateOfBirth.getTime()) + ", " + salary + ", "
				+ salaryAcc + ", " + seniority + ", " + vacationDays + ", "
				+ format1.format(dateOfLastVacation.getTime()) + ", "
				+ deptName + ", " + salaryToHandIn;
	}

	public String[] getEmployee(String[][] sirNames, String[][] names,
			String[][] patronymicName) {
		if (sirNames.length == 0 || names.length == 0
				|| patronymicName.length == 0) return null;

		int sex = (int) (Math.random() * 2);
		int inx1 = 0;

		if (sex == 1) { // male
			inx1 = (int) (Math.random() * sirNames.length);
			while (Integer.parseInt(sirNames[inx1][1]) < sex) {
				inx1 = (int) (Math.random() * sirNames.length);
			}
		}
		else { // female
			inx1 = (int) (Math.random() * sirNames.length);
			while (Integer.parseInt(sirNames[inx1][1]) > sex) {
				inx1 = (int) (Math.random() * sirNames.length);
			}
		}

		int inx2 = (int) (Math.random() * names.length);
		while (Integer.parseInt(names[inx2][1]) != sex) {
			inx2 = (int) (Math.random() * names.length);
		}

		int inx3 = (int) (Math.random() * patronymicName.length);
		while (Integer.parseInt(patronymicName[inx3][1]) != sex) {
			inx3 = (int) (Math.random() * patronymicName.length);
		}

		return new String[] { sirNames[inx1][0], names[inx2][0],
				patronymicName[inx3][0], Integer.toString(sex) };

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSirName() {
		return sirName;
	}

	public void setSirName(String sirName) {
		this.sirName = sirName;
	}

	public double getSalaryToHandIn() {
		return salaryToHandIn;
	}

	public void setSalaryToHandIn(double salaryToHandIn) {
		this.salaryToHandIn = salaryToHandIn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymicName() {
		return patronymicName;
	}

	public void setPatronymicName(String patronymicName) {
		this.patronymicName = patronymicName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalaryAcc() {
		return salaryAcc;
	}

	public void setSalaryAcc(double salaryAcc) {
		this.salaryAcc = salaryAcc;
	}

	public double getSeniority() {
		return seniority;
	}

	public void setSeniority(double seniority) {
		this.seniority = seniority;
	}

	public double getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(double vacationDays) {
		this.vacationDays = vacationDays;
	}

	public GregorianCalendar getDateOfLastVacation() {
		return dateOfLastVacation;
	}

	public void setDateOfLastVacation(GregorianCalendar dateOfLastVacation) {
		this.dateOfLastVacation = dateOfLastVacation;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
