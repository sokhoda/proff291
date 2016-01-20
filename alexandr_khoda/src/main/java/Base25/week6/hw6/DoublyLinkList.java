package Base25.week6.hw6;

public class DoublyLinkList {
	private DNode	first;

	public DoublyLinkList() {
		this.first = null;
	}

	public void addLast(int elVal) {
		DNode cur = first;
		if (first == null) {
			first = new DNode(elVal, null);
		}
		else {
			while (cur.getNext() != null) {
				cur = cur.getNext();
			}
			cur.setNext(new DNode(elVal, cur));
		}
	}

	public void delete(int inx) {
		DNode cur = first;
		if (first == null) return;
		if (inx == 0) {
			if (cur.getNext() != null) {
				setFirst(cur.getNext());
				first.setPrev(null);
			}
			else setFirst(null);
			return;
		}
		int k = 0;
		while (cur.getNext() != null && k < inx) {
			cur = cur.getNext();
			k++;
		}
		if (k == inx) {

			if (cur.getPrev() != null) cur.getPrev().setNext(cur.getNext());
			if (cur.getNext() != null) cur.getNext().setPrev(cur.getPrev());
		}
		else System.out.println("������ �������� ������ ������� ������.");
	}

	public void addFirst(int element) {
		if (first != null) {
			first.setPrev(new DNode(element, first, null));
			setFirst(first.getPrev());
		}
		else first = new DNode(element, null);
	}

	public DNode getElement(int inx) {
		if (first == null) return null;

		DNode cur = first;
		int k = 0;
		while (cur.getNext() != null && k < inx) {
			cur = cur.getNext();
			k++;
		}
		if (k != inx) {
			System.out.println("\n������� � �������� [" + inx + "] �� ������");
			return null;
		}
		else return cur;
	}

	public int size() {
		if (first == null) return 0;

		DNode cur = first;
		int k = 1;
		while (cur.getNext() != null) {
			cur = cur.getNext();
			k++;
		}
		return k;
	}

	public void sortPartial(int inx) {
		if (getElement(inx) == null) return;
		if (size() <= 1) return;

		// DNode midElem = getElement(inx);
		// System.out.println("inx = " + inx + " el= " + midElem.getValue());

		swapElem(0, inx);
		int curInx = 0;
		int p;
		int i = 1;
		while (i < size()) {
			if ((getElement(i).compareTo(getElement(curInx)) > 0 && i < curInx)
					|| (getElement(i).compareTo(getElement(curInx)) < 0 && i > curInx)) {

				swapElem(i, curInx);

				if (curInx < i) p = curInx + 1;
				else p = i + 1;
				curInx = i;
				i = p;
				// System.out.println(i);
			}
			else i++;
		}
		// System.out.println("inx = " + inx + " el= " + midElem.getValue());

	}

	public void swapElem(int inx1, int inx2) {
		if (first == null || first.getNext() == null) return;
		if (inx1 == inx2) return;
		if (inx1 > inx2) {
			int a = inx1;
			inx1 = inx2;
			inx2 = a;
		}
		DNode cur = first;
		int k = 0;
		while (cur.getNext() != null && k < inx1) {
			cur = cur.getNext();
			k++;
		}
		if (k != inx1) {
			System.out.println("\n������� � �������� [" + inx1 + "] �� ������");
			return;
		}
		DNode e1 = cur;
		DNode next1 = cur.getNext();
		DNode prev1 = cur.getPrev();
		while (cur.getNext() != null && k < inx2) {
			cur = cur.getNext();
			k++;
		}
		if (k != inx2) {
			System.out.println("\n������� � �������� [" + inx2 + "] �� ������");
			return;
		}
		DNode e2 = cur;
		DNode next2 = cur.getNext();
		DNode prev2 = cur.getPrev();

		if (prev1 != null) prev1.setNext(e2);
		if (inx2 - inx1 > 1) {
			e2.setNext(next1);
		}
		else e2.setNext(e1);

		if (prev2 != null) if (inx2 - inx1 > 1) prev2.setNext(e1);

		e1.setNext(next2);

		if (next1 != null) if (inx2 - inx1 > 1) next1.setPrev(e2);
		e2.setPrev(prev1);
		if (next2 != null) next2.setPrev(e1);
		if (inx2 - inx1 > 1) {
			e1.setPrev(prev2);
		}
		else e1.setPrev(e2);

		if (inx1 == 0) setFirst(e2);

	}

	public void revert() {
		if (first == null || first.getNext() == null) return;
		DNode cur = first;
		DNode node1 = cur.getNext();
		cur.setNext(cur.getPrev());
		cur.setPrev(node1);

		while (cur.getPrev() != null) {
			cur = cur.getPrev();
			node1 = cur.getNext();
			cur.setNext(cur.getPrev());
			cur.setPrev(node1);
		}
		setFirst(cur);
	}

	public void printRevert() {
		DNode cur = first;
		if (first == null) return;
		while (cur.getNext() != null) {
			cur = cur.getNext();
		}
		System.out.print(cur.getValue());
		while (cur.getPrev() != null) {
			cur = cur.getPrev();
			System.out.print(", " + cur.getValue());
		}
		System.out.println();
	}

	public void print() {

		DNode cur = first;
		if (first != null) {
			System.out.print(cur.getValue());
			while (cur.getNext() != null) {
				cur = cur.getNext();
				System.out.print(", " + cur.getValue());
			}

		}
		else System.out.print("\n<empty>");
		System.out.println();
	}

	public DNode getFirst() {
		return first;
	}

	public void setFirst(DNode first) {
		this.first = first;
	}
}
