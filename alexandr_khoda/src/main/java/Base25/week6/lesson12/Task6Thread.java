package Base25.week6.lesson12;

import java.util.ArrayList;

public class Task6Thread extends Thread {
	private ArrayList<Product>	list;
	private int					startInx;
	private int					numOfValues;
	private long				sum	= 0;

	public Task6Thread(ArrayList<Product> list, int startInx, int numOfValues) {
		this.list = list;
		this.startInx = startInx;
		this.numOfValues = numOfValues;
		this.sum = 0;
	}

	@Override
	public void run() {
		for (int i = startInx; i < startInx + numOfValues; i++) {
			sum += list.get(i).getKol() * list.get(i).getPrice();
			// System.out
			// .println(this.getName() + ", sum = " + sum + ", i = " + i);
		}
		setSum(sum);
	}

	public ArrayList<Product> getList() {
		return list;
	}

	public void setList(ArrayList<Product> list) {
		this.list = list;
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

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

}
