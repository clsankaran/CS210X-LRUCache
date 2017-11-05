public class Node<T, U> {

	T _key;
	U _value;
	Node _previous;
	Node _next;

	public Node(T key, U value) {
		_key = key;
		_value = value;
		_previous=null;
		_next=null;
	}

	public U getValue() {
		return _value;
	}
	
	public T getKey() {
		return _key;
	}
	public Node getPrevious() {
		return _previous;
	}
	
	public Node getNext() {
		return _next;
	}

	public void setPrevious(Node n) {
		_previous = n;
	}

	public void setNext(Node n) {
		_next = n;
	}
}
