package Base25.week7.lesson13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ThreadClient extends Thread {
	private String			val;
	private String			fileFolder;
	private ThreadServer 	server;

	public ThreadClient(ThreadServer server, String fileFolder) {
		this.server = server;
		this.fileFolder = fileFolder;
	}

	private static String getFname() {
		int sec = GregorianCalendar.getInstance().get(Calendar.SECOND);
		int min = GregorianCalendar.getInstance().get(Calendar.MINUTE);
		int hour = GregorianCalendar.getInstance().get(Calendar.HOUR);
		int day = GregorianCalendar.getInstance().get(Calendar.DAY_OF_YEAR);
		return Integer.toString(day) + "_" + Integer.toString(hour) + "_"
		+ Integer.toString(min) + "_" + Integer.toString(sec) + ".cht";
	}

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		String entry = scan.nextLine();
		String curFname = getFname();
		while (!entry.equals("exit")) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(fileFolder + curFname);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				try {
					oos.writeObject(entry);
					// System.out.println(car1.toString());
				}
				finally {
					oos.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}

			entry = scan.nextLine();
			curFname = getFname();
		}
		System.out.println("завершение работы клиента. спасибо.");
		server.interrupt();
	}
}
