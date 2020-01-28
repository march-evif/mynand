package mynand.hack.gates;

import java.util.ArrayList;
import java.util.List;

public class Node {

	protected short value;

	protected List<Node> listener = new ArrayList<>();

	public Node(short initialValue) {
		this.value = initialValue;
	}

	public short get() {
		return this.value;
	}

	public void set(short value) {
		if (this.value == value) {
			return;
		}

		this.value = value;
		this.listener.forEach(node -> node.set(value));
	}

	public void addListener(Node node) {
		this.listener.add(node);
	}

	public void removeListener(Node node) {
		this.listener.remove(node);
	}
}
