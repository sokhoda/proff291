package Base25.week6.lesson11;

public class MainTask2 {
	public static void main(String[] args) {
		Task2<Integer> val = new Task2<Integer>();
		val.add(10);
		val.add(230);
		System.out.println(val.getArr());
		System.out.println(val.get(1));
	}
}
