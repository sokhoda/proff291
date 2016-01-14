package Base25.week7.lesson14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CreatorThread extends Thread {
	private File	file1;
	private Object	objSynchro;

	public CreatorThread(Object objSynchro, File file1) {
		this.objSynchro = objSynchro;
		this.file1 = file1;
	}

	@Override
	public void run() {

		Reader isr = new InputStreamReader(System.in);
		BufferedReader d = new BufferedReader(isr);

		while (true) {

			try {
				String str = d.readLine();
				FileWriter fw = new FileWriter(file1);
				fw.write(str);
				fw.flush();
				fw.close();
				synchronized (objSynchro) {
					objSynchro.notify();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
