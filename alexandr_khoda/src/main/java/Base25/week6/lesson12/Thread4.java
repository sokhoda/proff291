package Base25.week6.lesson12;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread4 extends Thread {
	private String				title;
	private int					numOfValues;
	private ArrayList<Integer>	arr;
	private boolean				done;
	private Lock				myLock	= new ReentrantLock(true);
	private Condition			arrSize;

	public Thread4(String title, ArrayList<Integer> arr, int numOfValues) {
		this.title = title;
		this.arr = arr;
		this.done = false;
		this.numOfValues = numOfValues;
		arrSize = myLock.newCondition();
	}

	@Override
	public void run() {
		for (int i = 0; i < numOfValues; i++) {
			arr.add(arr.size() + 1);
			// System.out.println(arr.get(arr.size() - 1) + " " + getTitle());
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getnumOfValues() {
		return numOfValues;
	}

	public void setnumOfValues(int numOfValues) {
		this.numOfValues = numOfValues;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
