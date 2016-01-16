package Base25.week6.lesson12;

import java.util.Vector;

public class Thread4Vect extends Thread {
	private String			title;
	private int				startVal;
	private int				numOfValues;
	private Vector<Integer>	vector;

	public Thread4Vect(String title, Vector<Integer> vector, int startVal,
			int numOfValues) {
		this.title = title;
		this.vector = vector;
		this.startVal = startVal;
		this.numOfValues = numOfValues;
	}

	public Thread4Vect(String title, Vector<Integer> vector, int numOfValues) {
		this.title = title;
		this.vector = vector;
		this.startVal = 0;
		this.numOfValues = numOfValues;
	}

	@Override
	public void run() {
		for (int i = 0; i < numOfValues; i++) {
			vector.add(vector.size() + 1);
			// System.out
			// .println(vector.get(vector.size() - 1) + " " + getTitle());
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getstartVal() {
		return startVal;
	}

	public void setstartVal(int startVal) {
		this.startVal = startVal;
	}

	public int getnumOfValues() {
		return numOfValues;
	}

	public void setnumOfValues(int numOfValues) {
		this.numOfValues = numOfValues;
	}
}
