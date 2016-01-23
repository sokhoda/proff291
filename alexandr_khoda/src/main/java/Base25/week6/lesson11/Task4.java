package Base25.week6.lesson11;

public class Task4 {
	public static int checkInt(String s) {
		try {
			return Integer.valueOf(s);
		}
		catch (Exception e) {
			throw new NullPointerException();
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(checkInt("f34"));
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("mm");
		}
	}
}
