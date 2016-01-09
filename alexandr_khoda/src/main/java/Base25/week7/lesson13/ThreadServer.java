package Base25.week7.lesson13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ThreadServer extends Thread {
	private ArrayList<String>	list		= new ArrayList<String>();
	private ArrayList<String>	readFiles	= new ArrayList<String>();
	private String				fileFolder;
	static final String	extDelimiter	= ".";

	public ThreadServer(String fileFolder) {
		this.fileFolder = fileFolder;
	}


	public static String getExtension(String fName) {
		String res = "";
		if ((fName.length() == 0) || (fName.indexOf(extDelimiter) == -1)) { return res; }

		int i = fName.length();
		String exten = "";
		while (i - 1 >= 0) {
			if (!(fName.substring(i - 1, i).equals(extDelimiter))) {
				exten = fName.substring(i - 1, i) + exten;
			}
			else {
				break;
			}
			i--;
		}
		// System.out.println("ext = " + exten);
		return exten;
	}

	@Override
	public void run() {
		if (fileFolder.length() == 0) {
			System.out.println("Не валидный путь к фалам чата. " + getName());
			return;
		}
		File myFolder = new File(fileFolder);
		File[] files = myFolder.listFiles();

		for (File file : files) {
			if (!file.isDirectory()
					&& getExtension(file.getName()).equals("cht")) {
				file.delete();
			}
		}

		try {
			while (true) {

				files = myFolder.listFiles();
				for (File file : files) {
					if (!file.isDirectory()) {
						String curFname = file.getName();

						if (getExtension(curFname).equals("cht")
								&& !readFiles.contains(curFname)) {

							FileInputStream fis = null;
							try {
								fis = new FileInputStream(fileFolder + curFname);
								// System.out.println(FNameIn + "\\" +
								// curFname);
							}
							catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							try {
								ObjectInputStream oin;
								oin = new ObjectInputStream(fis);
								try {
									list.add("\n" + (String) oin.readObject());
									readFiles.add(curFname);
									System.out.println(list);
								}
								catch (ClassNotFoundException e) {
									e.printStackTrace();
								}

								finally {
									oin.close();
								}
							}
							catch (IOException e) {
								e.printStackTrace();
							}

						}
					}
				}

				sleep(2000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("завершение работы сервера. спасибо.");
			return;
		}
	}
}
