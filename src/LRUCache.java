import java.util.HashMap;

/**
 * An implementation of <tt>Cache</tt> that uses a least-recently-used (LRU)
 * eviction policy.
 */

public class LRUCache<T, U> implements Cache<T, U> {

	private int _numMisses;
	private DataProvider<T, U> _provider;
	private int _capacity;
	private HashMap<T, Node<T, U>> _storedValues;
	private Node<T, U> _mostRecent;
	private Node<T, U> _leastRecent;

	/**
	 * 
	 * Node class for values of _storedValues
	 *
	 * @param <T>
	 *            type of key
	 * @param <U>
	 *            type of value
	 */

	private class Node<T, U> {

		T _key;
		U _value;
		Node<T, U> _previous;
		Node<T, U> _next;

		private Node(T key, U value, Node<T, U> previous, Node<T, U> next) {
			_key = key;
			_value = value;
			_previous = previous;
			_next = next;
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
		_mostRecent = null;
		_leastRecent = null;
		_storedValues = new HashMap<T, Node<T, U>>();

	}

	/**
	 * Returns the value associated with the specified key.
	 * 
	 * @param key
	 *            the key
	 * @return the value associated with the key
	 */
	public U get(T key) {
		if (_storedValues.containsKey(key)) { // hit
			final Node<T, U> desiredNode = _storedValues.get(key);
			if (!(_mostRecent.equals(desiredNode))) {
				moveToMostRecent(desiredNode);
			}
			return desiredNode._value;

		}

		else { // miss
			final Node<T, U> newNode = new Node<T, U>(key, _provider.get(key), null, _mostRecent);
			if (_storedValues.size() >= _capacity) { // need to evict
				_storedValues.remove(_leastRecent._key);
			}
			_storedValues.put(key, newNode);
			_numMisses++;
			return (U) newNode._value;
		}

	}

	private void moveToMostRecent(Node<T, U> node) {
		node._previous._next = node._next;
		node._next = _mostRecent;
		node._previous = null;
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
