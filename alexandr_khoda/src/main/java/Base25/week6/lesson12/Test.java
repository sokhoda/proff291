package Base25.week6.lesson12;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {

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

	public static void main(String[] args) throws InterruptedException {

		int curDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int curMonth = Calendar.getInstance().get(Calendar.MONTH);
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(curDay + " " + curMonth + "  " + curYear);
		Calendar date1 = new GregorianCalendar(2015, 11, 20);
		Calendar date2 = new GregorianCalendar(2012, 04, 20);
		System.out.println(date1.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(date2.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(monthsBetween(date1, date2));
		System.out.println((char) (65));
		System.out.println((int) ('А'));
		String s = "12.12.2005";
		Date dd = new Date(33);

		String[] f = s.split("\\.");
		System.out.println(Arrays.toString(f));
		boolean bl = true;
		while (true) {
			int curSecond = Calendar.getInstance().get(Calendar.SECOND);
			if (curSecond % 2 == 0) bl = true;
			if (bl) {
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss")
						.format(Calendar.getInstance().getTime());
				System.out.println(timeStamp);
				bl = false;
				Thread.sleep(1000);
			}
		}
	}
}
