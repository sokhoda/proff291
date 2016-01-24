package Base25.week6.hw6;

public class DNode implements Comparable<DNode> {
	private int		value;
	private DNode	next;
	private DNode	prev;

	public DNode(int value, DNode next, DNode prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

	@Override
	public int compareTo(DNode o) {
		return (new Integer(this.value)).compareTo(new Integer(o.getValue()));
	}

	public DNode(int value, DNode prev) {
		this(value, null, prev);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public DNode getPrev() {
		return prev;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}

}
