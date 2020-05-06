package string;

public class ReverseSentence {
//	static String reverseWords(String s) {
//		int i=0; 
//		System.out.println(s);
//		if(s.length()==0)
//			return "";
//		while(s.charAt(i)!=' '||i==s.length()) {
//			i++;
//			if(i==s.length()-1)
//				break;
//		}
//		System.out.println("i is: "+i+"word is: "+s.substring(0, i));
//		return  reverseWords(s.substring(i+1))+" "+ s.substring(0, i);
//	}
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
