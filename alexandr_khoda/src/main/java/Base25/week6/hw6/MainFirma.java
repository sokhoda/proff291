package Base25.week6.hw6;

import Base25.week6.hw6.Employee;
import Base25.week6.hw6.Firma;
import Base25.week6.hw6.Manager;
import Base25.week6.hw6.Seller;

public class MainFirma {
	static int	ThreadNum	= 1;
	static int	employeeNum	= 40;
	static int	managerNum	= 10;
	static int	sellerNum	= 10;

	public static void main(String[] args) {
		Firma firma = new Firma(1e6f);
		String[][] sirNames = { { "Аржаєва", "0" }, { "Барабаш", "10" },
				{ "Бількевич", "10" }, { "Бондаренко", "10" },
				{ "Бончик", "10" }, { "Бортнік", "10" }, { "Борцова", "0" },
				{ "Воронова", "0" }, { "Скоростенська", "0" },
				{ "Калініченко", "10" }, { "Кізілов", "1" },
				{ "Кобилецький", "1" }, { "Колпак", "10" }, { "Литвин", "10" },
				{ "Микитенко", "10" }, { "Новак", "10" }, { "Редькіна", "0" },
				{ "Рубан", "10" }, { "Рябченко", "10" }, { "Самсонюк", "10" },
				{ "Соколова", "0" }, { "Степчук", "10" }, { "Сушицький", "1" },
				{ "Тригуб", "0" }, { "Фецак", "10" }, { "Числовська", "0" },
				{ "Швець", "10" }, { "Шкапенко", "10" }, { "Шлапак", "10" },
				{ "Яковенко", "10" }, };

		String[][] names = { { "Аліса", "0" }, { "Анна", "0" },
				{ "Валерія", "0" }, { "Вікторія", "0" }, { "Віталій", "1" },
				{ "Галина", "0" }, { "Данило", "1" }, { "Євгенія", "0" },
				{ "Єлизавета", "0" }, { "Йосип", "1" }, { "Іван", "1" },
				{ "Ігор", "1" }, { "Катерина", "0" }, { "Кристина", "0" },
				{ "Максим", "1" }, { "Маргарита", "0" }, { "Марина", "0" },
				{ "Марія", "0" }, { "Микола", "1" }, { "Наталія", "0" },
				{ "Оксана", "0" }, { "Олександр", "1" }, { "Олександра", "0" },
				{ "Олексій", "1" }, { "Олена", "0" }, { "Павло", "1" },
				{ "Петро", "1" }, { "Сергій", "1" }, { "Соломія", "0" },
				{ "Тетяна", "0" } };

		String[][] patronymicName = { { "Анатоліївна", "0" },
				{ "Анатолійович", "1" }, { "Андріївна", "0" },
				{ "Андрійович", "1" }, { "Борисівна", "0" },
				{ "Борисович", "1" }, { "Василівна", "0" },
				{ "Васильович", "1" }, { "Вікторівна", "0" },
				{ "Вікторович", "1" }, { "Володимирівна", "0" },
				{ "Володимирович", "1" }, { "Вячеславівна", "0" },
				{ "Вячеславович", "1" }, { "Денисівна", "0" },
				{ "Денисович", "1" }, { "Ігорівна", "0" }, { "Ігоревич", "1" },
				{ "Костянтинівна", "0" }, { "Костянтинович", "1" },
				{ "Олегівна", "0" }, { "Олегович", "1" },
				{ "Олександрівна", "0" }, { "Олександрович", "1" },
				{ "Павлівна", "0" }, { "Павлович", "1" }, { "Романівна", "0" },
				{ "Романович", "1" }, { "Сергіївна", "0" },
				{ "Сергійович", "1" }, { "Юріївна", "0" }, { "Юрійович", "1" }, };

		String[] departments = { "логістики", "продажів роздрібних",
				"продажів оптових", "закупівель", "автоматизації",
				"зв'язків з покупцями", "маркетинговий", "технічний" };
		// Employee e1 = new Employee(sirNames, names, patronymicName,
		// departments, firma);
		// Manager e1 = new Manager(sirNames, names, patronymicName,
		// departments,
		// firma, 3);
		// System.out.println(e1);
		for (int i = 0; i < employeeNum; i++) {
			firma.getEmployee().add(
					new Employee(sirNames, names, patronymicName, departments,
							firma));
		}
		for (int i = 0; i < managerNum; i++) {
			firma.getEmployee().add(
					new Manager(sirNames, names, patronymicName, departments,
							firma, (int) (Math.random() * (employeeNum / 5.))));
		}
		for (int i = 0; i < sellerNum; i++) {
			firma.getEmployee().add(
					new Seller(sirNames, names, patronymicName, departments,
							firma));
		}
		// System.out.println(firma.getEmployee());
		// firma.sortBySalary();
		// System.out
		// .println("\n\n\n------------------ SORT BY SALARY -----------------------");
		// firma.printEmployee();

		firma.sortByID(firma.getEmployee());
		System.out
				.println("\n\n\n------------------ SORT BY ID -----------------------");
		firma.printEmployee();

		// firma.sortBySirName();
		// System.out
		// .println("\n\n\n------------------ SORT BY SurName -----------------------");
		// firma.printEmployee();

		// firma.sellAmount(1500);
		// System.out.println("\n\n\nsold 1000\n");
		// firma.printEmployee();
		//
		// try {
		// firma.paySalary();
		// }
		// catch (FirmaAccNotEnoughtMoneyToPaySalaryException e) {
		// e.printStackTrace();
		// // System.out.println(e.getMessage());
		// }
		// System.out.println("\n\n\nPAY SALARY\n");
		// firma.printEmployee();
		//
		// firma.countVacationDays();
		// System.out
		// .println("\n\n\n----------COUNT VACATION DAYS--------------------\n");
		// firma.printEmployee();
		//
		// firma.raiseSalary();
		// System.out
		// .println("\n\n\n----------RAISE SALARY--------------------\n");
		// firma.printEmployee();
		//
		// firma.dismissal();
		// System.out
		// .println("\n\n\n------------------------------DISMISSAL--------------------\n");
		// firma.printEmployee();

		firma.employ(departments);
		System.out
				.println("\n\n\n------------------------------NEW WORKERS EMPLOYED--------------------\n");
		firma.sortByDeptName();
		firma.printEmployee();

		// while (true) {
		// Scanner d = new Scanner(System.in);
		// int t = d.nextInt();
		//
		// System.out.println(t + ", " + firma.binarySearchByID(t));
		// }
		//
		// int f = firma.binarySearchByID(firma.getEmployee()
		// .get(firma.getEmployee().size() - 1).getSubordId().get(0));
		// System.out.println(f);

	}
}
