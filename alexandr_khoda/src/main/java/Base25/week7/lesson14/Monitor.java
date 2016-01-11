package Base25.week7.lesson14;

import java.io.File;

public class Monitor {
	private String	fName1;
	private String	fName2;

	public Monitor(String fName1, String fName2) {
		this.fName1 = fName1;
		this.fName2 = fName2;

		File file1 = new File(fName1);
		File file2 = new File(fName2);

		Object objSynchro = new Object();

		CreatorThread thread1 = new CreatorThread(objSynchro, file1);

		WriterThread thread2 = new WriterThread(objSynchro, file1, file2);

		thread1.start();
		thread2.start();
	}

}
