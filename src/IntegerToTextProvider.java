
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
		else if (key==11)
			return "eleven";
		else if (key==12)
			return "twelve";
		else if (key==13)
			return "thirteen";
		else if (key==13)
			return "fourteen";
		else if (key==14)
			return "fifteen";
		else if (key==15)
			return "sixteen";
		else if (key==16)
			return "seventeen";
		else if (key==17)
			return "eighteen";
		else if (key==18)
			return "nineteen";
		else if (key==19)
			return "twenty";
		else
			return "int not in range";
	}

}
