package recursionPracticeBasic;

public class StarBetweenTwoSame {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s="aabccccdeee";
       System.out.println("Given string  "+s);
       System.out.println("After evaluation  "+operation(s));
	}
	static String operation(String s) {
		if(s.length()-1==0)
			return s;
		if(s.charAt(0)==s.charAt(1)) {
			s=s.substring(0,1)+"*"+s.substring(1);
		}
		return s.charAt(0)+operation(s.substring(1));
	}
}
