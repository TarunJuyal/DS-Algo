package recursionPracticeBasic;

public class PiToItsNumericValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s="ppipipipppi";
       System.out.println("Given string  "+s);
       System.out.println("After evaluation  "+piValueChange(s));
	}
	static String piValueChange(String s) {
		if(s.length()==0)
			return s;
		if(s.charAt(0)=='p'&& s.charAt(1)=='i') {
			s="3.14"+s.substring(2);
		}
		return s.charAt(0)+piValueChange(s.substring(1));
	}

}
