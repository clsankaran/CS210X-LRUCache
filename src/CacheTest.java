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
	public void testSingleEntry() {
		cache = new LRUCache<Integer, String>(provider,1);
		cache.get(1);
		assertTrue(cache.getNumMisses() == 1);
		cache.get(1);
		assertTrue(cache.getNumMisses() == 1);
	}

}
