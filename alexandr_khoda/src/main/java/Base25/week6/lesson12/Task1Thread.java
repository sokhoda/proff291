package Base25.week6.lesson12;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task1Thread extends Thread {
	@Override
	public void run() {

		try {
			while (true) {
				sleep(2000);
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss")
						.format(Calendar.getInstance().getTime());
				System.out.println(timeStamp);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

	}
}
