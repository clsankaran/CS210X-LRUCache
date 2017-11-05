
public class IntegerToTextProvider implements DataProvider<Integer, String>{

	@Override
	public String get(Integer key) {
		// TODO Auto-generated method stub
		return convertIntToString(key);
	}

	private String convertIntToString(Integer key) {
		if (key==0)
			return "zero";
		else if (key==1)
			return "one";
		// TODO Nilay finish these until 20
		else
			return "int not in range";
	}

}
