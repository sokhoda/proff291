package Base25.week6.lesson12;

import java.util.Vector;

public class Task5ThreadVect extends Thread {
	private Vector<Integer>	vector;
	private int				startInx;
	private int				numOfValues;
	private int				sum	= 0;

	@Override
	public void run() {

		for (int i = startInx; i < startInx + numOfValues; i++) {
			sum += vector.get(i);
		}
	}

	public Task5ThreadVect(Vector<Integer> vector, int startInx, int numOfValues) {
		super();
		this.vector = vector;
		this.startInx = startInx;
		this.numOfValues = numOfValues;
		this.sum = 0;
	}

	public Task5ThreadVect(Vector<Integer> vector, int startInx) {
		this.vector = vector;
		this.startInx = startInx;
	}

	public Vector<Integer> getvector() {
		return vector;
	}

	public void setvector(Vector<Integer> vector) {
		this.vector = vector;
	}

	public int getStartInx() {
		return startInx;
	}

	public void setStartInx(int startInx) {
		this.startInx = startInx;
	}

	public int getNumOfValues() {
		return numOfValues;
	}

	public void setNumOfValues(int numOfValues) {
		this.numOfValues = numOfValues;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
