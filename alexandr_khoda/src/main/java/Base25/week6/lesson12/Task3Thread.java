package Base25.week6.lesson12;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3Thread extends Thread {
	private String	nameTh;

	public String getnameTh() {
		return nameTh;
	}

	public void setnameTh(String nameTh) {
		this.nameTh = nameTh;
	}

	public Task3Thread(String nameTh) {
		this.nameTh = nameTh;
	}

	@Override
	public void run() {

		final int ThreadNum = 10;

		ArrayList<ChildThread> arr = new ArrayList<ChildThread>(ThreadNum);

		for (int i = 0; i < ThreadNum; i++) {
			arr.add((new ChildThread("поток_" + i)));
			arr.get(i).start();
		}

		Scanner scan = new Scanner(System.in);
		Character val = null;
		int k = 0;

		while (k < ThreadNum) {
			val = scan.next().charAt(0);
			if (val != null) {
				arr.get(k++).interrupt();
				val = null;
			}
		}
	}

}
