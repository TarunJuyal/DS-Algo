package recursionPracticeBasic;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s="98713";
		System.out.println("String "+s+" when converted to numbers is :- " );
		System.out.print((int)convert(s));
	}
	public static double convert(String s) {
		if(s.length()==0)
			return 0;
		return ((s.charAt(0)-'0')*Math.pow(10, s.length()-1))+convert(s.substring(1));
	} 

}
