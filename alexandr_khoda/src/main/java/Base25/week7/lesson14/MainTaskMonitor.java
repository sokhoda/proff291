package Base25.week7.lesson14;


public class MainTaskMonitor {
	public static void main(String[] args) {
		String fNameIn = "E:\\1\\lesson14\\";
		String fName1 = "MonitorFile1.txt";
		String fName2 = "MonitorFile2.txt";

		Monitor monitor = new Monitor(fNameIn + fName1, fNameIn + fName2);

	}
}
