import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Code to test an <tt>LRUCache</tt> implementation.
 */
public class CacheTest {

	// instance variables
	final private DataProvider<Integer, String> provider = new IntegerToTextProvider();
	private Cache<Integer, String> cache; // not final because two different caches are used

	@Test
	/**
	 * This method will test the cache system with an LRUCache of capacity four.
	 */
	public void testMultipleNodes() {
		cache = new LRUCache<Integer, String>(provider, 4);
		cache.get(1);
		assertTrue(cache.getNumMisses() == 1);
		cache.get(1); // making sure that calling most and least recent works
		assertTrue(cache.getNumMisses() == 1);
		cache.get(2);
		assertTrue(cache.getNumMisses() == 2);
		cache.get(2); // making sure that calling most but not least recent works
		assertTrue(cache.getNumMisses() == 2);
		cache.get(1); // making sure that calling least but not most recent works
		assertTrue(cache.getNumMisses() == 2);
		cache.get(2); // making the most recent 2 instead of 1
		assertTrue(cache.getNumMisses() == 2);
		cache.get(3);
		assertTrue(cache.getNumMisses() == 3);
		cache.get(4);
		assertTrue(cache.getNumMisses() == 4);
		cache.get(5); // capacity full, need to evict
		assertTrue(cache.getNumMisses() == 5);
		cache.get(1); // making sure that the least recently used was evicted
		assertTrue(cache.getNumMisses() == 6);
		cache.get(1); // making sure that it doesn't miss AND making sure that calling most recent
						// works
		assertTrue(cache.getNumMisses() == 6);
		cache.get(4); // making sure that calling not most nor least recent works
		assertTrue(cache.getNumMisses() == 6);
	}

	@Test
	/**
	 * This method will test the cache system with an LRUCache of capacity one.
	 */
	public void testSingleNode() {
		cache = new LRUCache<Integer, String>(provider, 1);
		cache.get(10);
		assertTrue(cache.getNumMisses() == 1);
		cache.get(10); // making sure that calling most recent works
		assertTrue(cache.getNumMisses() == 1);
		cache.get(11); // making sure that it misses
		assertTrue(cache.getNumMisses() == 2);
		cache.get(10); // making sure that it misses
		assertTrue(cache.getNumMisses() == 3);
		cache.get(10); // making sure that it doesn't miss
		assertTrue(cache.getNumMisses() == 3);
	}

}