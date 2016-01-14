package Base25.week7.lesson13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainTask2 {
	final static int	maxId	= 7;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("������� ���������� ����:");
		int count = scan.nextInt();

		for (int i = 0; i < count; i++) {
			int id = (int) (Math.random() * 1000) + 1000;
			int eng = (int) (Math.random() * 100000) + 100000;
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("E:\\1\\auto" + i + ".out");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				try {
					Car car1 = new Car("AA " + id, new Engine(eng));
					oos.writeObject(car1);
					System.out.println(car1.toString());
				}
				finally {
					oos.close();
				}
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("���������.");
	}
}
