import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Code to test an <tt>LRUCache</tt> implementation.
 */
public class CacheTest {

	@Test
	public void leastRecentlyUsedIsCorrect () {
		DataProvider<Integer,String> provider = new IntegerToTextProvider(); // Need to instantiate an actual DataProvider
		Cache<Integer,String> cache = new LRUCache<Integer,String>(provider, 4);
	}

	@Test
	public void testSingleEntry() {
		DataProvider<Integer,String> provider = new IntegerToTextProvider();
		Cache<Integer, String> cache = new LRUCache<Integer, String>(provider,1);
		cache.get(1);
		assertTrue(cache.getNumMisses() == 1);
	}

}
