public class MyList {
	private Node firstNode;
	private Node lastNode;
	private int count = 0;

	public MyList() {}

	public MyList(Element element) {
		this.firstNode= new Node(element);
		this.lastNode = firstNode;
		this.count = 1;
	}

	public void addElementAtEnd(Element element) {
		Node newNode = new Node(element);

		if (firstNode == null) {
			this.firstNode = newNode;
			this.lastNode = firstNode;
		} else {
			newNode.setPrevNode(this.lastNode);
			this.lastNode.setNextNode(newNode);
			this.lastNode = newNode;
		}
		this.count++;
	}

	public void addElementAtStart(Element element) {
		Node newNode = new Node(element);

		if (firstNode == null) {
			this.firstNode = newNode;
			this.lastNode = firstNode;
		} else {
			Node firstNodeTmp = this.firstNode;

			firstNodeTmp.setPrevNode(newNode);
			this.firstNode = newNode;
			this.firstNode.setNextNode(firstNodeTmp);
		}
		this.count++;
	}

	public void deleteElementAtStart() {
		if (count == 0) {
			return;
		}
		if (count == 1) {
			this.firstNode = null;
			this.lastNode = null;
			this.count = 0;
			return;
		}
		Node nextNodeTmp = this.firstNode.getNextNode();

		this.firstNode = nextNodeTmp;
		this.firstNode.setPrevNode(null);
		this.count--;
	}

	public void deleteElementAtEnd() {
		if (count == 0) {
			return;
		}
		if (count == 1) {
			this.firstNode = null;
			this.lastNode = null;
			this.count = 0;
			return;
		}
		Node prevNodeTmp = this.lastNode.getPrevNode();
		this.lastNode = prevNodeTmp;
		this.lastNode.setNextNode(null);
		this.count--;
	}

	public void addElementAtPosition(Element element, int position) {
		if (position >= this.count) {
			this.addElementAtEnd(element);
		} else if (position == 0) {
			this.addElementAtStart(element);
		} else {
			Node newNode = new Node(element);
			Node nodeTmp = getNodeAtPosition(position);
			Node prevNodeTmp = nodeTmp.getPrevNode();
			nodeTmp.setPrevNode(newNode);
			prevNodeTmp.setNextNode(newNode);
			newNode.setNextNode(nodeTmp);
			newNode.setPrevNode(prevNodeTmp);
			this.count++;
		}
	}

	public void deleteElementAtPosition(int position) {
		if (position >= this.count) {
			this.deleteElementAtEnd();
		} else if (position == 0) {
			this.deleteElementAtStart();
		} else {
			Node nodeTmp = getNodeAtPosition(position);
			Node prevNodeTmp = nodeTmp.getPrevNode();
			Node nextNodeTmp = nodeTmp.getNextNode();

			prevNodeTmp.setNextNode(nextNodeTmp);
			nextNodeTmp.setPrevNode(prevNodeTmp);
			this.count++;
		}
	}

	private Node getNodeAtPosition(int position) {
		if (position < this.count / 2) {
			Node nodeTmp = this.firstNode;
			int index = 0;
			while (index < position) {
				nodeTmp = nodeTmp.getNextNode();
				index++;
			}
			return nodeTmp;
		} else {
			Node nodeTmp = this.lastNode;
			int tmpCount = this.count;
			while (tmpCount > position + 1) {
				nodeTmp = nodeTmp.getPrevNode();
				tmpCount--;
			}
			return nodeTmp;
		}
	}

	public void printList() {
		Node nodetmp = this.firstNode;

		while (nodetmp != null) {
			Element element = nodetmp.getElement();
			System.out.println(element.getValue());
			nodetmp = nodetmp.getNextNode();
		}
	}
}
