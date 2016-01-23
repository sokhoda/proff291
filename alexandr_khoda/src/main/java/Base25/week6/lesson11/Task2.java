package Base25.week6.lesson11;

import java.util.ArrayList;

public class Task2<T> {
	private ArrayList<T>	arr	= new ArrayList<T>();

	public ArrayList getArr() {
		return arr;
	}

	public void setArr(ArrayList arr) {
		this.arr = arr;
	}

	public T get(int inx) {
		if (inx > -1) return arr.get(inx);
		return null;
	}

	public void add(T val) {
		arr.add(val);
	}

}
