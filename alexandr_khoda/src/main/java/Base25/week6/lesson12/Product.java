package Base25.week6.lesson12;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Product {

	private String				name;
	private int					code;
	private int					price;
	private int					kol;
	private GregorianCalendar	date;

	public Product(String name, int code, int price, int kol,
			GregorianCalendar date) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.kol = kol;
		this.date = date;
	}

	@Override
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
		return name + "\t" + code + "\t" + price + "\t" + kol + "\t"
		+ format1.format(date.getTime()) + "\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKol() {
		return kol;
	}

	public void setKol(int kol) {
		this.kol = kol;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

}
