
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
		else if (key==2)
			return "two";
		else if (key==3)
			return "three";
		else if (key==4)
			return "four";
		else if (key==5)
			return "five";
		else if (key==6)
			return "six";
		else if (key==7)
			return "seven";
		else if (key==8)
			return "eight";
		else if (key==9)
			return "nine";
		else if (key==10)
			return "ten";
		else
			return "int not in range";
	}
}
