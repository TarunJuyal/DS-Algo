package string;

public class ReverseSentence {
	static String reverseWords(String s) {
		String result="";
		String str[]=s.split(" ");
		for(String i:str) {
			result+=" "+reverseStringUtil(i);
		}
		return result;
	}
	static String reverseString(String s) {
		String str=reverseWords(s);
		return reverseStringUtil(str);
	}
	static String reverseStringUtil(String s) {
		if(s.length()==0)
			return s;
		return reverseStringUtil(s.substring(1))+s.charAt(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="I love java";
		System.out.println(reverseString(s));
	}

}
