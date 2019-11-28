public class Node {
	private Element element;
	private Node next;
	private Node prev;

	public Node(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Node getNextNode() {
		return next;
	}

	public void setNextNode(Node next) {
		this.next = next;
	}

	public Node getPrevNode() {
		return prev;
	}

	public void setPrevNode(Node prev) {
		this.prev = prev;
	}
}
