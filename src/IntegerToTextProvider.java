
/**
 * An implementation of <tt>DataProvider</tt> that converts Integer keys into
 * String values.
 *
 * Note: used different data types to ensure T and U were not used
 * interchangeably.
 */
public class IntegerToTextProvider implements DataProvider<Integer, String> {

	@Override
	/**
	 * This method will call upon the convertIntToString method to return the value
	 * of the number key to a string of the number.
	 *
	 * @param key
	 *            the key
	 */
	public String get(Integer key) {
		return convertIntToString(key);
	}

	/**
	 * This method will check every key from 0 to 20 and return the key that is
	 * called upon as a string. If it is not within the range of 0 to 20 it will
	 * return that it is not in the range.
	 *
	 * @param key
	 *            the key
	 */
	private String convertIntToString(Integer key) {
		if (key == 0)
			return "zero";
		else if (key == 1)
			return "one";
		else if (key == 2)
			return "two";
		else if (key == 3)
			return "three";
		else if (key == 4)
			return "four";
		else if (key == 5)
			return "five";
		else if (key == 6)
			return "six";
		else if (key == 7)
			return "seven";
		else if (key == 8)
			return "eight";
		else if (key == 9)
			return "nine";
		else if (key == 10)
			return "ten";
		else if (key == 11)
			return "eleven";
		else if (key == 12)
			return "twelve";
		else if (key == 13)
			return "thirteen";
		else if (key == 14)
			return "fourteen";
		else if (key == 15)
			return "fifteen";
		else if (key == 16)
			return "sixteen";
		else if (key == 17)
			return "seventeen";
		else if (key == 18)
			return "eighteen";
		else if (key == 19)
			return "nineteen";
		else if (key == 20)
			return "twenty";
		else
			return "int not in range";
	}

}