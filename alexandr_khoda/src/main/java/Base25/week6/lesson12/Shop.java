package Base25.week6.lesson12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Shop implements Runnable {
	public final static int		CodeNum	= 100000;
	private ArrayList<Product>	list	= new ArrayList<Product>();

	@Override
	public void run() {

	}

	public void add(Product product) {
		list.add(product);
	}

	public int getCode() {
		int rand = (int) (Math.random() * CodeNum);

		while (binarySearchByCode(rand, false) != -1) {
			rand = (int) (Math.random() * CodeNum);
		}
		return rand;
	}

	public void sortByCode() {
		Collections.sort(list, new CodeSortProduct());
	}

	public void sortByDate() {
		Collections.sort(list, new DateSortProduct());
	}

	public int binarySearchByCode(int code, boolean throwException) {
		sortByCode();
		if (list == null) return -1;
		if (list.size() == 0) return -1;

		int lBound = 0;
		int rBound = list.size() - 1;
		boolean cond = (list.get(lBound).getCode() == code)
				|| (list.get(rBound).getCode() == code);

		while ((!cond) && (rBound - lBound) > 1) {
			int center = (rBound + lBound) / 2;

			if (code < list.get(center).getCode()) rBound = center;
			else lBound = center;
			cond = (list.get(lBound).getCode() == code)
					|| (list.get(rBound).getCode() == code);
		}
		if (cond) {
			if (list.get(lBound).getCode() == code) return lBound;
			else return rBound;
		}
		else {
			if (throwException) {
				try {
					throw new NullProductByCodeException(
							"Товар с заданным кодом не найден. code =" + code);
				}
				catch (NullProductByCodeException e) {
					e.printStackTrace();
					// System.out.println(e.getMessage() + "\ncode = " + code);
					return -1;
				}
			}
			else return -1;
		}
	}

	public int binarySearchByDate(String date) {
		sortByDate();
		if (list == null) return -1;
		if (list.size() == 0) return -1;

		GregorianCalendar gregDate = new GregorianCalendar();
		try {
			gregDate.setTime(new SimpleDateFormat("dd.MM.yyyy").parse(date));
		}
		catch (ParseException e) {
			System.out.println("Невалидный формат даты: dd.MM.yyyy");
			e.printStackTrace();
			return -1;
		}

		int lBound = 0;
		int rBound = list.size() - 1;
		boolean cond = (list.get(lBound).getDate().equals(gregDate))
				|| (list.get(rBound).getDate().equals(gregDate));

		while ((!cond) && (rBound - lBound) > 1) {
			int center = (rBound + lBound) / 2;

			if (gregDate.compareTo(list.get(center).getDate()) < 0) rBound = center;
			else lBound = center;
			cond = (list.get(lBound).getDate().equals(gregDate))
					|| (list.get(rBound).getDate().equals(gregDate));
		}
		if (cond) {
			if (list.get(lBound).getDate().equals(gregDate)) return lBound;
			else return rBound;
		}
		else {
			try {
				throw new NullProductByDateException(
						"Товар с заданной датой закупки не найден. date = "
								+ date);
			}
			catch (NullProductByDateException e) {
				// e.printStackTrace();
				System.out.println(e.getMessage());
				return -1;
			}
		}
	}

	//
	// public int binarySearchByCode(int code) {
	// BinarySearcher bs = new BinarySearcher();
	//
	// return bs.binarySearch(getCodeArr(), code);
	// }

	public void printList() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("\n" + "%25s %15s %8s %10s %15s", list.get(i)
					.getName(), list.get(i).getCode(), list.get(i).getPrice(),
					list.get(i).getKol(), format1.format(list.get(i).getDate()
							.getTime()));
		}
	}

	public Product getProduct(int inx) {
		if (inx < list.size()) return list.get(inx);
		else return null;
	}

	public ArrayList<Product> getList() {
		return list;
	}

	public void setList(ArrayList<Product> list) {
		this.list = list;
	}

}
