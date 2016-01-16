package Base25.week7.lesson13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainTask3 {
	static final String	extDelimiter	= ".";

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

	public static void main(String[] args) {
		ArrayList<Car> auto = new ArrayList<Car>();

		String FNameIn = "E:\\1";
		if (FNameIn.length() > 0) {

			File myFolder = new File(FNameIn);
			File[] files = myFolder.listFiles();
			for (File file : files) {
				if (!file.isDirectory()) {
					String curFname = file.getName();
					if (getExtension(curFname).equals("out")) {

						FileInputStream fis = null;
						try {
							fis = new FileInputStream(FNameIn + "\\" + curFname);
							// System.out.println(FNameIn + "\\" + curFname);
						}
						catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						try {
							ObjectInputStream oin;
							oin = new ObjectInputStream(fis);
							try {
								auto.add((Base25.week7.lesson13.Car) oin
										.readObject());
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

			System.out.println(auto);

		}
	}
}