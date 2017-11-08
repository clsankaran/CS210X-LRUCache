import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Code to test an <tt>LRUCache</tt> implementation.
 */
public class CacheTest {

	private DataProvider<Integer,String> provider = new IntegerToTextProvider();
	private Cache<Integer,String> cache;

	@Test
	public void testMultipleEntry() {
		cache = new LRUCache<Integer, String>(provider,4);
		cache.get(1);
		cache.get(2);
		cache.get(3);
		cache.get(4);
		assertTrue(cache.getNumMisses() == 4);
		cache.get(5);
		assertTrue(cache.getNumMisses() == 5);
		cache.get(1);
		assertTrue(cache.getNumMisses() == 6);
	}

	@Test
	public void testSingleEntry() {
		cache = new LRUCache<Integer, String>(provider,1);
		cache.get(1);
		assertTrue(cache.getNumMisses() == 1);
		cache.get(1);
		assertTrue(cache.getNumMisses() == 1);
	}

}
