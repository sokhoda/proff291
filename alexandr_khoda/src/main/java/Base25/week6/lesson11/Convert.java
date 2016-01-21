package Base25.week6.lesson11;

import java.util.ArrayList;

public class Convert {
	public static <T> ArrayList<T> convertArr2List(T[] a) {
		ArrayList<T> list = new ArrayList<T>();
		if (a.length > 0) {
			for (T element : a) {
				list.add(element);
			}
		}
		return list;
	}

}
