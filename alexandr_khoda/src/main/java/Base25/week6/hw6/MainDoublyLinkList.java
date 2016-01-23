package Base25.week6.hw6;

public class MainDoublyLinkList {
	public static void main(String[] args) {
		DoublyLinkList list = new DoublyLinkList();
		System.out.println(list.size());
		list.revert();
		list.swapElem(0, 0);
		list.print();
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));
		list.addFirst((int) (Math.random() * 500));

		list.revert();
		list.print();
		System.out.println(list.size());
		list.addFirst(-111);
		list.print();
		list.printRevert();

		list.addLast((int) (Math.random() * 500));
		list.addLast((int) (Math.random() * 500));
		list.addLast((int) (Math.random() * 500));
		list.addLast((int) (Math.random() * 500));
		list.addLast((int) (Math.random() * 500));
		list.addLast((int) (Math.random() * 500));
		list.addLast((int) (Math.random() * 500));

		list.print();
		list.addLast(12);
		list.print();
		list.addLast(344);

		list.print();
		list.addFirst(909);
		list.print();
		System.out.println(list.size());
		list.revert();
		list.print();
		list.swapElem(4, 0);
		System.out.println("swap(4,0)");
		list.print();

		int k = (int) (Math.random() * list.size());
		System.out.println("sort partial (" + k + ") = "
				+ list.getElement(k).getValue());
		list.sortPartial(k);

		list.print();
		System.out.println(list.getElement(5).getValue());
		list.printRevert();
		// list.addLast(-34);
		// list.print();
		// list.addLast(4);
		// list.print();
		// list.delete(1);
		// list.print();
		// list.delete(0);
		// list.print();
		// list.printRevert();
		// list.delete(0);
		// list.print();
		// list.printRevert();
		// list.delete(0);
		// list.print();
		// list.printRevert();
		// list.delete(0);
		// list.print();
		// list.delete(0);
		// list.print();
		// list.addLast(10);
		// list.print();
		// list.addLast(12);
		// list.print();
		// list.addLast(344);

	}
}
