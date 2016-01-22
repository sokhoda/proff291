package Base25.week6.hw6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Firma {

	private ArrayList<AbstractEmployee>	employee	= new ArrayList<AbstractEmployee>();
	// private ArrayList<Seller> seller = new ArrayList<Seller>();
	// private ArrayList<Manager> manager = new ArrayList<Manager>();
	// money of the firma
	private double						minSalary	= 1467.;
	private double						acc;

	public Firma(double acc) {
		this.acc = acc;
	}

	public void paySalary() throws FirmaAccNotEnoughtMoneyToPaySalaryException {
		System.out.println("\nAccount State: " + getAcc());
		for (AbstractEmployee empl : employee) {
			if (empl.getSalaryToHandIn() > getAcc()) {
				throw new FirmaAccNotEnoughtMoneyToPaySalaryException(
						"Недостаточно денег на счету фирмы (" + getAcc()
						+ ") для выплаты зарплаты, сотрудник "
						+ empl.getSirName() + " " + empl.getName());
			}
			else {
				empl.setSalaryAcc(empl.getSalaryAcc()
						+ empl.getSalaryToHandIn());
				setAcc(getAcc() - empl.getSalaryToHandIn());
				empl.setSalaryToHandIn(0);
				empl.setSalesMonthly(0);
			}
		}
	}

	public void countVacationDays() {
		int curDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int curMonth = Calendar.getInstance().get(Calendar.MONTH);
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		GregorianCalendar curDate = new GregorianCalendar(curYear, curMonth,
				curDay);

		for (AbstractEmployee empl : employee) {
			double monthDiff = AbstractEmployee.monthsBetween(curDate,
					empl.getDateOfLastVacation());
			if (monthDiff >= 6.) {
				empl.setVacationDays(monthDiff * 2);
			}
		}
	}

	public void raiseSalary() {
		for (AbstractEmployee empl : employee) {
			if (empl.getSeniority() > 5.) {
				empl.setSalary(empl.getSalary() * 1.1);
			}
		}
	}

	public void getDeptWorkers(ArrayList<Integer> deptWorkers,
			int emplInxToExclude) {
		if (emplInxToExclude >= 0) {
			if (deptWorkers == null) {
				System.out.println("не валидный список сотрудников");
				return;
			}
			for (int j = 0; j < employee.size(); j++) {
				if (employee.get(emplInxToExclude).getDeptName()
						.equals(employee.get(j).getDeptName())
						&& emplInxToExclude != j) {
					deptWorkers.add(j);
				}
			}

		}
	}

	public void getDeptWorkers(ArrayList<Integer> deptWorkers, String deptName) {
		if (deptName.length() == 0) {
			System.out.println("название подразделения имеет нудевую длину");
			return;
		}
		if (deptWorkers == null) {
			System.out.println("не валидный список сотрудников");
			return;
		}
		for (int j = 0; j < employee.size(); j++) {
			if (employee.get(j).getDeptName().equals(deptName)) deptWorkers
					.add(j);
		}
	}

	public void dismissal() {
		ArrayList<Integer> deptWorkers = new ArrayList<Integer>();

		for (int i = 0; i < employee.size(); i++) {
			if (employee.get(i).getSeniority() < 0.5
					&& (employee.get(i).getDateOfBirth()
							.get(Calendar.DAY_OF_MONTH) % 2) == 1) {
				System.out.println("dismissed: " + employee.get(i).getId()
						+ " " + employee.get(i).getSirName() + " "
						+ employee.get(i).getName() + ", "
						+ employee.get(i).getDeptName());
				deptWorkers.clear();
				for (AbstractEmployee empl : employee) {
					if (empl.getSubordId().size() > 0) {
						// int inx = ((Manager) empl)
						// .binarySearchByIDSubOrdinates(employee.get(i)
						// .getId());
						int inx = empl.binarySearchByIDSubOrdinates(employee
								.get(i).getId());

						if (inx != -1) {
							System.out
							.println("removing subordinate from Manager "
									+ empl.getSirName()
									+ " "
									+ empl.getId()
									+ ": "
									+ empl.getSubordId().get(inx));

							empl.getSubordId().remove(inx);

						}
					}
					// ------
					getDeptWorkers(deptWorkers, i);
				}
				if (deptWorkers.size() > 0) {
					double salaryPart = employee.get(i).getSalary()
							/ deptWorkers.size();
					for (int j = 0; j < deptWorkers.size(); j++) {
						int inx = deptWorkers.get(j);
						employee.get(inx).setSalary(
								employee.get(inx).getSalary() + salaryPart);
						System.out.println(j + ". raising salary for "
								+ employee.get(inx).getId() + ", "
								+ employee.get(inx).getSirName() + " by "
								+ salaryPart);
					}
				}
				employee.remove(i);
			}
		}
	}

	public void employ(String[] departments) {
		ArrayList<Integer> deptWorkers = new ArrayList<Integer>();
		String sirName = "";
		String name;
		String patronymicName;
		GregorianCalendar dateOfBirth = new GregorianCalendar();
		double salary;
		double seniority; // years

		Scanner scan = new Scanner(System.in);

		Reader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		while (!sirName.trim().equals("exit")) {
			deptWorkers.clear();
			System.out
			.println("Введите фамилию (exit - закончить добавление сотрудников): ");
			sirName = scan.nextLine();
			if (sirName.trim().equals("exit")) return;

			System.out.println("Введите имя: ");
			name = scan.nextLine();

			System.out.println("Введите отчество: ");
			patronymicName = scan.nextLine();

			int depInx = -1;
			while (depInx < 0 || depInx >= departments.length) {

				System.out.println("Выберите название отдела: ");
				for (int i = 0; i < departments.length; i++) {
					System.out.println(i + ". " + departments[i]);
				}

				try {
					String s = br.readLine();
					depInx = Integer.parseInt(s);

					if (depInx < 0 || depInx >= departments.length) System.out
					.println("некорректный индекс отдела");
				}
				catch (Exception ex) {
					System.out.println("\nнекорректный индекс отдела: "
							+ ex.getMessage());
				}
			}

			int sex = -1;
			while (sex != 0 && sex != 1) {
				System.out.println("Выберите пол: 0 - женский, 1 - мужской");
				try {
					String s = br.readLine();
					sex = Integer.parseInt(s);
					if (sex != 0 && sex != 1) System.out
					.println("некорректный пол");
				}
				catch (Exception ex) {
					System.out
					.println("\nнекорректный пол: " + ex.getMessage());
				}
			}

			int workType = -1;
			while (workType != 1 && workType != 2 && workType != 3) {
				System.out
				.println("Выберите тип сотрудника: 1 - Обычный сотрудник, 2 - менеджер, 3 - продавец");
				try {
					String s = br.readLine();
					workType = Integer.parseInt(s);
					if (workType != 1 && workType != 2 && workType != 3) System.out
					.println("\nнекорректный тип сотрудника");
				}
				catch (Exception ex) {
					System.out.println("\nнекорректный тип сотрудника: "
							+ ex.getMessage());
				}
			}
			Scanner scan2 = new Scanner(System.in);
			String[] dateArr = { "0" };
			int dateOK = 0;
			while (dateArr.length != 3 || dateOK == 0) {
				System.out.println("Введите дату рождения (dd.mm.yyyy): ");
				String dateStr = scan2.nextLine();
				dateArr = dateStr.split("\\.");
				try {
					int dd = Integer.parseInt(dateArr[0]);
					int mm = Integer.parseInt(dateArr[1]) - 1;
					int yyyy = Integer.parseInt(dateArr[2]);

					dateOfBirth = new GregorianCalendar(yyyy, mm, dd);

					dateOK = 1;
				}
				catch (Exception ex) {
					System.out.println("\nнекорректная дата рождения: "
							+ ex.getMessage());
				}
			}

			salary = -1;
			while (salary <= 0) {
				System.out.println("Введите размер зарплаты:");
				try {
					String s = br.readLine();
					salary = Double.parseDouble(s);

					getDeptWorkers(deptWorkers, departments[depInx]);
					double incremSal = salary / deptWorkers.size();
					ArrayList<Integer> emplInx = new ArrayList<Integer>();
					double gatheredSalary = 0.;
					double gatheredSalaryRich = 0.;
					System.out
					.println("//--------------информация для насчитывания зарплаты "
							+ sirName + " " + name);
					for (int j = 0; j < deptWorkers.size(); j++) {
						AbstractEmployee e1 = employee.get(deptWorkers.get(j));
						System.out
						.printf("\n%3d. %5s %15s %15s %15s %7s sal=%8.2f misal=%8.2f dif=%8.2f incr=%8.2f newsal=%8.2f %25s",
								j, e1.getId(), e1.getSirName(),
								e1.getName(), e1.getPatronymicName(),
								e1.getEmployeeType(), e1.getSalary(),
								getMinSalary(), e1.getSalary()
								- getMinSalary(), incremSal,
								e1.getSalary() - incremSal,
								e1.getDeptName());
					}
					System.out
					.println("\n//-----------конец информации для насчитывания зарплаты ");

					for (int k = 0; k < deptWorkers.size(); k++) {
						int i = deptWorkers.get(k);
						if (employee.get(i).getSalary() - getMinSalary() < incremSal) {
							if (employee.get(i).getSalary() - getMinSalary() > 0) {
								gatheredSalary += employee.get(i).getSalary()
										- getMinSalary();
								emplInx.add(i);
							}
						}
						else {
							if (salary - gatheredSalaryRich >= incremSal) {
								gatheredSalaryRich += incremSal;
								employee.get(i)
								.setSalary(
										employee.get(i).getSalary()
										- incremSal);
								AbstractEmployee e1 = employee.get(i);
								System.out
								.printf("\n%3d. %5s %15s %15s %15s %7s sal=%8.2f misal=%8.2f dif=%8.2f incr=%8.2f %25s",
										i,
										e1.getId(),
										e1.getSirName(),
										e1.getName(),
										e1.getPatronymicName(),
										e1.getEmployeeType(),
										e1.getSalary(),
										getMinSalary(),
										e1.getSalary() - getMinSalary(),
										incremSal, e1.getDeptName());
							}
							else {
								gatheredSalaryRich += salary
										- gatheredSalaryRich;
								employee.get(i)
								.setSalary(
										employee.get(i).getSalary()
										- (salary - gatheredSalaryRich));
								AbstractEmployee e1 = employee.get(i);
								System.out
								.printf("\n%3d. %5s %15s %15s %15s %7s sal=%8.2f misal=%8.2f dif=%8.2f incr=%8.2f %25s",
										i,
										e1.getId(),
										e1.getSirName(),
										e1.getName(),
										e1.getPatronymicName(),
										e1.getEmployeeType(),
										e1.getSalary(),
										getMinSalary(),
										e1.getSalary() - getMinSalary(),
										incremSal, e1.getDeptName());
								System.out.println("\n break");
								break;
							}
						}
					}

					if (gatheredSalaryRich < salary) {
						System.out.println("\ngatheredSalaryRich < salary");
						for (int i = 0; i < emplInx.size(); i++) {
							if (salary - gatheredSalaryRich >= employee.get(
									emplInx.get(i)).getSalary()
									- getMinSalary()) {
								gatheredSalaryRich += employee.get(
										emplInx.get(i)).getSalary()
										- getMinSalary();
								employee.get(emplInx.get(i)).setSalary(
										getMinSalary());

							}
							else {
								gatheredSalaryRich += salary
										- gatheredSalaryRich;
								employee.get(emplInx.get(i))
								.setSalary(
										employee.get(emplInx.get(i))
										.getSalary()
										- (salary - gatheredSalaryRich));
							}
							AbstractEmployee e1 = employee.get(emplInx.get(i));
							System.out
							.printf("\n%3d. %5s %15s %15s %15s %7s sal=%8.2f misal=%8.2f dif=%8.2f incr=%8.2f %25s",
									i, e1.getId(), e1.getSirName(),
									e1.getName(),
									e1.getPatronymicName(),
									e1.getEmployeeType(),
									e1.getSalary(), getMinSalary(),
									e1.getSalary() - getMinSalary(),
									incremSal, e1.getDeptName());
						}
					}
					if (gatheredSalaryRich < salary) {
						System.out
						.printf("\nК сожалению, при сохранении мин. зарплаты существующим сотрудникам в размере %.2f "
								+ "можно установить зарплату новому сотруднику %s %s в размере %.2f",
								getMinSalary(), sirName, name,
								gatheredSalaryRich);
						salary = gatheredSalaryRich;
					}

				}
				catch (Exception ex) {
					System.out.println("\nнекорректное значение зарплаты"
							+ ex.getMessage());
				}
			}

			seniority = -1;
			while (seniority < 0) {
				System.out.println("\nВведите стаж (лет):");
				try {
					String s = br.readLine();
					seniority = Double.parseDouble(s);
				}
				catch (Exception ex) {
					System.out.println("\nнекорректное значение стажа"
							+ ex.getMessage());
				}
			}

			if (workType == 1) {
				employee.add(new Employee(sirName, name, patronymicName, sex,
						this, dateOfBirth, salary, seniority,
						departments[depInx]));
			}
			if (workType == 2) {
				int subOrdID = -1;
				ArrayList<Integer> subOrdIDArr = new ArrayList<Integer>();
				printEmployee();
				System.out
				.println("Выберите Id подчиненных (0 -закончить добавление подчиненных):");
				while (subOrdID != 0) {
					try {
						String s = br.readLine();
						subOrdID = Integer.parseInt(s);
						if (subOrdID > 0) {
							if (binarySearchByID(subOrdID) == -1) {
								System.out.println("сотрудник с ID " + subOrdID
										+ " не найден.");
							}
							else subOrdIDArr.add(subOrdID);
						}
						if (subOrdID < 0) {
							System.out
							.println("ID сотрудника не может быть отрицательным");
						}
					}
					catch (Exception ex) {
						System.out.println("\n" + ex.getMessage());
					}
				}

				employee.add(new Manager(sirName, name, patronymicName, sex,
						this, dateOfBirth, salary, seniority,
						departments[depInx], subOrdIDArr));
			}

			if (workType == 3) {
				int salesMonthly = -1;
				while (salesMonthly < 0) {
					System.out.println("Введите размер месячных продаж:");
					try {
						salesMonthly = scan.nextInt();
					}
					catch (InputMismatchException ex) {
						System.out.println("\n" + ex.getMessage());
					}
				}

				employee.add(new Seller(sirName, name, patronymicName, sex,
						this, dateOfBirth, salary, seniority,
						departments[depInx], salesMonthly));

			}
		}
		sortByID(employee);

	}

	public void payBonus() {

		int curDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int curMonth = Calendar.getInstance().get(Calendar.MONTH);
		if (curDay == 8 && curMonth == 3) {
			for (AbstractEmployee empl : employee) {
				if (empl.getSex() == 0) {
					empl.setSalaryToHandIn(empl.getSalaryToHandIn() + 0.2
							* empl.getSalary());
				}
			}
		}
		if (curDay == 23 && curMonth == 2) {
			for (AbstractEmployee empl : employee) {
				if (empl.getSex() == 1) {
					empl.setSalaryToHandIn(empl.getSalaryToHandIn() + 0.2
							* empl.getSalary());
				}
			}
		}
	}

	public void printEmployee() {

		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
		for (int i = 0; i < employee.size(); i++) {
			AbstractEmployee e1 = employee.get(i);
			System.out
			.printf("\n%3d. %5s %15s %15s %15s %5s %15s %5s %5s %8s %8.2f %6s %5.1f %5.1f %15s %25s %10s",
					i,
					e1.getId(),
					e1.getSirName(),
					e1.getName(),
					e1.getPatronymicName(),
					e1.getSex() == 1 ? "чол" : "жін",
							format1.format(e1.getDateOfBirth().getTime()),
							e1.getEmployeeType(),
							e1.getSubordId().size(),
							e1.getSalesMonthly(),
							e1.getSalary(),
							e1.getSalaryAcc(),
							e1.getSeniority(),
							e1.getVacationDays(),
							format1.format(e1.getDateOfLastVacation().getTime()),
							e1.getDeptName(), e1.getSalaryToHandIn());

			System.out.print(e1.getStrSubordinates(this));

		}
		System.out.println("\nAccount State: " + getAcc());
	}

	public void sellAmount(int money) {
		for (AbstractEmployee e : employee) {
			e.sellAmount(money);
		}
	}

	public void sortBySirName() {
		Collections.sort(employee, new SurNameSortEmployee());
	}

	public void sortBySalary() {
		Collections.sort(employee, new SalarySortEmployee());
	}

	public void sortByDeptName() {
		Collections.sort(employee, new DeptSortEmployee());
	}

	public void sortByID(ArrayList<AbstractEmployee> employee) {
		Collections.sort(employee);
	}

	public int binarySearchByID(int id) {
		ArrayList<AbstractEmployee> employee = new ArrayList<AbstractEmployee>();
		for (AbstractEmployee abstractEmployee : this.employee) {
			employee.add(abstractEmployee);
		}

		sortByID(employee);
		if (employee.size() == 0) return -1;

		int lBound = 0;
		int rBound = employee.size() - 1;
		boolean cond = (employee.get(lBound).getId() == id)
				|| (employee.get(rBound).getId() == id);

		while ((!cond) && (rBound - lBound) > 1) {
			int center = (rBound + lBound) / 2;

			if (id < employee.get(center).getId()) rBound = center;
			else lBound = center;
			cond = (employee.get(lBound).getId() == id)
					|| (employee.get(rBound).getId() == id);
		}
		if (cond) {
			if (employee.get(lBound).getId() == id) return lBound;
			else return rBound;
		}
		else {
			return -1;
		}
	}

	public AbstractEmployee binarySearchByIDAbstrEmployee(int id) {
		ArrayList<AbstractEmployee> employee = new ArrayList<AbstractEmployee>();
		for (AbstractEmployee abstractEmployee : this.employee) {
			employee.add(abstractEmployee);
		}
		sortByID(employee);
		if (employee.size() == 0) return null;

		int lBound = 0;
		int rBound = employee.size() - 1;
		boolean cond = (employee.get(lBound).getId() == id)
				|| (employee.get(rBound).getId() == id);

		while ((!cond) && (rBound - lBound) > 1) {
			int center = (rBound + lBound) / 2;

			if (id < employee.get(center).getId()) rBound = center;
			else lBound = center;
			cond = (employee.get(lBound).getId() == id)
					|| (employee.get(rBound).getId() == id);
		}
		if (cond) {
			if (employee.get(lBound).getId() == id) return employee.get(lBound);
			else return employee.get(rBound);
		}
		else {
			return null;
		}
	}

	public ArrayList<AbstractEmployee> getEmployee() {
		return employee;
	}

	public void setEmployee(ArrayList<AbstractEmployee> employee) {
		this.employee = employee;
	}

	public double getAcc() {
		return acc;
	}

	public void setAcc(double acc) {
		this.acc = acc;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

}
