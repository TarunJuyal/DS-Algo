package recursionPracticeBasic;

public class OccurenceOfWordinAString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s="hello how are u how";
       String str="how";
       System.out.println("Given string  "+s);
       System.out.println("After evaluation "+str+" occurs "+operation(s,str)+" times.");
	}
	static int operation(String s,String str) {
		if(s.length()<str.length())
			return 0;
		if(s.substring(0,str.length()).equals(str)) {
			return operation(s.substring(str.length()),str)+1;
		}
		return operation(s.substring(1),str);
	}
}
