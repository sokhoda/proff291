package Base25.week6.lesson12;

import java.util.ArrayList;

public class Task5Thread extends Thread {
	private ArrayList<Integer>	arr;
	private int					startInx;
	private int					numOfValues;
	private int					sum	= 0;

	@Override
	public void run() {

		for (int i = startInx; i < startInx + numOfValues; i++) {
			sum += arr.get(i);
		}
	}

	public Task5Thread(ArrayList<Integer> arr, int startInx, int numOfValues) {
		super();
		this.arr = arr;
		this.startInx = startInx;
		this.numOfValues = numOfValues;
		this.sum = 0;
	}

	public Task5Thread(ArrayList<Integer> arr, int startInx) {
		this.arr = arr;
		this.startInx = startInx;
	}

	public ArrayList<Integer> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Integer> arr) {
		this.arr = arr;
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
