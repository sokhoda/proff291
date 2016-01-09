package Base25.week7.lesson14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Task1 {
	public static void readData1() throws IOException {
		Reader isr = new InputStreamReader(System.in);
		BufferedReader d = new BufferedReader(isr);

		String fName = d.readLine();

		String FNameIn = "E:\\1\\lesson14\\";
		if (FNameIn.length() == 0) return;
		System.out.println(FNameIn + fName);

		File myFile = new File(FNameIn + fName);
		// File[] files = myFolder.listFiles();
		if (myFile.isFile()) {
			InputStream is = new FileInputStream(myFile);

			int len = is.available();
			System.out.println(len);
			byte[] buf = new byte[len];
			int k = is.read(buf);
			System.out.println("k=" + k);
			for (byte b : buf)
				System.out.println("[" + b + "]=[" + (char) (b) + "]");
			String res = "";
			int i, j;
			i = 0;
			while (i < buf.length - 1) {
				res = "";
				while ((buf[i] != 13 || buf[i + 1] != 10) && buf[i] != 32
						&& i < buf.length - 1) {
					res += (char) buf[i];
					i++;
				}
				if ((buf[i] == 13 && buf[i + 1] == 10)) i += 2;
				if ((i < buf.length) && (buf[i] == 32)) i++;

				if (i <= buf.length - 2) System.out.println(2
						* Integer.parseInt(res) + ", ");
			}
			if (i < buf.length) System.out.println(2 * Integer.parseInt(res
					.trim() + Character.toString((char) buf[i]).trim()));
		}
		else {
			System.out.println("���� �� ����������: " + FNameIn + fName);
			return;
		}
	}

	// System.out.println("�� ����������: " + a);
	//
	// System.out.println(d.read());
	// System.out.println(d.read());
	// System.out.println(d.read());
	// System.out.println(d.read());

	public static void main(String[] args) {
		try {
			readData1();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
