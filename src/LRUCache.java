import java.util.HashMap;

/**
 * An implementation of <tt>Cache</tt> that uses a least-recently-used (LRU)
 * eviction policy.
 */

public class LRUCache<T, U> implements Cache<T, U> {

	private int _numMisses;
	private DataProvider<T, U> _provider;
	private int _capacity;
	private HashMap<T, Node> storedValues;
	private Node mostRecent;
	private Node leastRecent;

	private class Node<T, U> {

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

	/**
	 * @param provider
	 *            the data provider to consult for a cache miss
	 * @param capacity
	 *            the exact number of (key,value) pairs to store in the cache
	 */
	public LRUCache(DataProvider<T, U> provider, int capacity) {

		_numMisses = 0;
		_provider = provider;
		_capacity = capacity;
		mostRecent = null;
		leastRecent = null;

	}

	/**
	 * Returns the value associated with the specified key.
	 * 
	 * @param key
	 *            the key
	 * @return the value associated with the key
	 */
	public U get(T key) {
		if (storedValues.containsKey(key)) { // hit
			final Node desiredNode = storedValues.get(key);
			moveToMostRecent(desiredNode);
			return (U) desiredNode.getValue();

		}

		else { // miss
			final Node newNode = new Node(key, _provider.get(key));
			if (storedValues.size() >= _capacity) { //need to evict
				storedValues.remove(leastRecent.getKey());
			}
			storedValues.put(key, newNode);
			moveToMostRecent(newNode);
			_numMisses++;
			return (U) newNode.getValue();
		}

	}

	private void moveToMostRecent(Node desiredNode) {
		desiredNode.getPrevious().setNext(desiredNode.getNext());
		desiredNode.setNext(mostRecent);
		desiredNode.setPrevious(null);
	}

	/**
	 * Returns the number of cache misses since the object's instantiation.
	 * 
	 * @return the number of cache misses since the object's instantiation.
	 */
	public int getNumMisses() {
		return _numMisses;
	}

}
