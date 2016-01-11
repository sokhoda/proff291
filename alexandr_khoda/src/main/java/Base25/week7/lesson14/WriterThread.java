package Base25.week7.lesson14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WriterThread extends Thread {
	private File	file1;
	private File	file2;
	private Object	objSynchro;

	public WriterThread(Object objSynchro, File file1, File file2) {
		this.file1 = file1;
		this.file2 = file2;
		this.objSynchro = objSynchro;
	}

	@Override
	public void run() {

		while (true) {

			System.out.println("Writer");
			try {
				synchronized (objSynchro) {
					objSynchro.wait();
				}
				System.out.println("����� 2 ���������");

				ArrayList<String> list = new ArrayList<String>();

				FileReader fr = null;
				try {
					fr = new FileReader(file1);
					Scanner scan = new Scanner(fr);

					while (scan.hasNextLine()) {
						list.add(scan.nextLine());
					}
					scan.close();
					try {
						fr.close();
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}

				FileWriter fw = null;
				try {
					fw = new FileWriter(file2);
					for (int i = 0; i < list.size(); i++) {

						try {
							fw.write(list.get(i));
							fw.flush();
							fw.close();
						}
						catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				catch (IOException e2) {
					e2.printStackTrace();
				}
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
