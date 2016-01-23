package Base25.week6.lesson11;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task5 {
	public static boolean exists(String fname) {
		try {
			FileReader Scanner = new FileReader(fname);
			return true;
		}
		catch (FileNotFoundException e) {
			throw new ArithmeticException("Error");
			// return false;
		}
	}

	public static void main(String[] args) {
		String s = "E:\\1\\Folder1\\Doc3.docx";
		System.out.println(s + ", exists =  " + exists(s));
	}
}
